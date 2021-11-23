package com.safers.db.entity.board;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.safers.db.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name="board_comment", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"board"})
public class BoardComment extends BaseEntity {
    @Column(name = "comment", columnDefinition = "TEXT")
    String comment;

    @Column(name="user_id", length = 13)
    String userId;

    @Column(name = "nick_name", length = 15)
    String nickName;

    @CreatedDate        // 생성 시간 저장 c.f. @LastModifiedDate => 수정 시간 저장
    @Column(name="reg_dt", columnDefinition = "TIMESTAMP")
    LocalDateTime regDt;

    @Column(name = "is_delete")
    Boolean isDelete;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="board_id")
    Board board;
}
