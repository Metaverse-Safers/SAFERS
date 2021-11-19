package com.safers.db.entity.board;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.safers.db.entity.BaseEntity;
import com.safers.db.entity.code.Code;
import com.safers.db.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="board", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Board extends BaseEntity {
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="user_id")
    User user;

    @Column(name = "title", length = 50)
    String title;

    @Column(name = "content", columnDefinition = "TEXT")
    String content;

    @CreatedDate
    @Column(name="reg_dt", columnDefinition = "TIMESTAMP")
    LocalDateTime regDt;

    @Column(name = "is_delete")
    Boolean isDelete;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "code")
    Code code;

    @JsonIgnore
    @OneToMany(mappedBy="board", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    private List<BoardComment> boardComment;

    @JsonIgnore
    @OneToMany(mappedBy="board", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    private List<BoardImage> boardImage;
}
