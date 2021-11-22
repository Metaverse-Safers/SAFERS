package com.safers.db.entity.board;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.safers.db.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="board_image", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"board"})
public class BoardImage extends BaseEntity {
    @Column(name = "file_path", columnDefinition = "TEXT")
    String filePath;

    @Column(name="file_name", columnDefinition = "TEXT")
    String fileName;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="board_id")
    Board board;
}
