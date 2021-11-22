package com.safers.db.repository;

import com.safers.db.entity.unity.Animals;
import com.safers.db.entity.unityLog.AnimalsLog;
import com.safers.db.entity.unityLog.AnimalsLogID;
import com.safers.db.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface AnimalsLogRepository extends JpaRepository<AnimalsLog, AnimalsLogID> {

    Optional<List<AnimalsLog>> findAllByUser(User user);
    Optional<AnimalsLog> findByUserAndAnimals(User user, Animals animals);

    @Transactional
    void deleteAllByUser(User user);
}
