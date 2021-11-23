package com.safers.db.repository;

import com.safers.db.entity.unity.Mission;
import com.safers.db.entity.unityLog.MissionLog;
import com.safers.db.entity.unityLog.MissionLogID;
import com.safers.db.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface MissionLogRepository extends JpaRepository<MissionLog, MissionLogID> {

    Optional<List<MissionLog>> findAllByUser(User user);
    Optional<MissionLog> findByUserAndMission(User user, Mission mission);

    @Transactional
    void deleteAllByUser(User user);
}
