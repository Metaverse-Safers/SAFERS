package com.safers.db.entity.board;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.safers.db.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    LocalDateTime regDt;

    @Column(name = "is_delete")
    Boolean isDelete;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="board_id")
    Board board;
}
