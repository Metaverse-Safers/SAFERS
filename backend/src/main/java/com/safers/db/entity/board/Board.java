package com.safers.db.entity.board;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.safers.db.entity.BaseEntity;
import com.safers.db.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="board", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board extends BaseEntity {
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="user_id")
    User user;

    @Column(name = "title", length = 50)
    String title;

    @Column(name = "content", columnDefinition = "TEXT")
    String content;

    @Column(name="reg_dt", columnDefinition = "TIMESTAMP")
    Date regDt;

    @Column(name = "is_delete")
    boolean isDelete;

    @JsonIgnore
    @OneToMany(mappedBy="board", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    private List<BoardComment> boardComment;

    @JsonIgnore
    @OneToMany(mappedBy="board", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    private List<BoardImage> boardImage;
}
