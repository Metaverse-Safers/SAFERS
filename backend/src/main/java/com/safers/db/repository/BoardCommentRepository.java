package com.safers.db.repository;

import com.safers.db.entity.board.Board;
import com.safers.db.entity.board.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardCommentRepository extends JpaRepository<BoardComment, String> {
    @Override
    Optional<BoardComment> findById(String commentId);

    Optional<List<BoardComment>> findAllByBoardEqualsAndIsDeleteEqualsOOrderByRegDtDesc(Board board, Boolean isDelete);

    Optional<List<BoardComment>> findAllByUserId(String userId);
}
