package com.safers.db.repository;

import com.safers.db.entity.board.Board;
import com.safers.db.entity.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, String> {

    Page<Board> findAllByIsDeleteEquals(Boolean isDelete, Pageable page);

    Page<Board> findAllByIsDeleteEqualsAndUserEquals(Boolean isDelete, User user, Pageable page);
    @Override
    Optional<Board> findById(String id);
}
