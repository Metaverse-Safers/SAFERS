package com.safers.db.repository;

import com.safers.db.entity.board.BoardImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardImageRepository extends JpaRepository<BoardImage, String> {

    List<BoardImage> findBoardImagesByFilePathEquals(String boardId);
}
