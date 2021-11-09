package com.safers.db.repository;

import com.safers.db.entity.unityLog.AnimalsLog;
import com.safers.db.entity.unityLog.MapLogID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalsLogRepository extends JpaRepository<AnimalsLog, MapLogID> {
}
