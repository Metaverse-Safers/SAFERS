package com.safers.db.repository;

import com.safers.db.entity.board.Board;
import com.safers.db.entity.board.BoardImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardImageRepository extends JpaRepository<BoardImage, String> {

    Optional<List<BoardImage>> findBoardImagesByBoardEquals(Board board);

    @Override
    Optional<BoardImage> findById(String id);

    @Transactional
    void deleteAllByBoardEquals(Board board);
}
