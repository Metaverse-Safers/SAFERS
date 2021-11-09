package com.safers.db.repository;

import com.safers.db.entity.unityLog.MapLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapLogRepository extends JpaRepository<MapLog, String> {
}
