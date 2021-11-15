package com.safers.db.repository;

import com.safers.db.entity.code.Code;
import com.safers.db.entity.code.CommonCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CommonCodeRepository extends JpaRepository<CommonCode, String> {
    Optional<List<CommonCode>> findByCommonCode(String commonCode);
}
