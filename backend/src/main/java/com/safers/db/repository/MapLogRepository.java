package com.safers.db.repository;

import com.safers.db.entity.unityLog.MapLog;
import com.safers.db.entity.unityLog.MapLogID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapLogRepository extends JpaRepository<MapLog, MapLogID> {
}
