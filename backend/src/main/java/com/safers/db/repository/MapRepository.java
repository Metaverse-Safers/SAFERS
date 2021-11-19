package com.safers.db.repository;

import com.safers.db.entity.board.BoardComment;
import com.safers.db.entity.unity.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapRepository extends JpaRepository<Map, String> {
}
