package com.safers.db.repository;

import com.safers.db.entity.unity.Animals;
import com.safers.db.entity.unity.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalsRepository extends JpaRepository<Animals, String> {

    Optional<List<Animals>> findAllByMap(Map map);
}
