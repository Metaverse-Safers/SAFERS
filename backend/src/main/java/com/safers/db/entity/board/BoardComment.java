package com.safers.db.entity.board;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.safers.db.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="board_comment", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardComment extends BaseEntity {
    @Column(name = "comment", columnDefinition = "TEXT")
    String comment;

    @Column(name="user_id", length = 13)
    String userId;

    @Column(name = "nick_name", length = 15)
    String nickName;

    @Column(name="reg_dt", columnDefinition = "TIMESTAMP")
    Date regDt;

    @Column(name = "is_delete")
    boolean isDelete;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="board_id")
    Board board;
}
