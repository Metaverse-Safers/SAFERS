package com.safers.db.repository;

import com.safers.db.entity.unityLog.MapLog;
import com.safers.db.entity.unityLog.MapLogID;
import com.safers.db.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface MapLogRepository extends JpaRepository<MapLog, MapLogID> {

    Optional<List<MapLog>> findAllByUser(User user);

    @Transactional
    void deleteAllByUser(User user);
}
