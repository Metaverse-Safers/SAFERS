package com.safers.db.repository;

import com.safers.db.entity.board.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, String> {

    Page<Board> findAllByIsDeleteEquals(Boolean isDelete, Pageable page);

}
