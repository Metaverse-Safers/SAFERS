package com.safers.db.repository;

import com.safers.db.entity.code.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CodeRepository extends JpaRepository<Code, String> {
}
