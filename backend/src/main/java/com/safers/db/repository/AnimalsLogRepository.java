package com.safers.db.repository;

import com.safers.db.entity.unityLog.AnimalsLog;
import com.safers.db.entity.unityLog.MapLogID;
import com.safers.db.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnimalsLogRepository extends JpaRepository<AnimalsLog, MapLogID> {

    Optional<List<AnimalsLog>> findAllByUser(User user);
    void deleteAllByUser(User user);
}
