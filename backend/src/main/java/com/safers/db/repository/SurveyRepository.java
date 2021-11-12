package com.safers.db.repository;

import com.safers.db.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SurveyRepository extends JpaRepository<Survey, String> {
    Optional<List<Survey>> findAllByArea(String area);
}
