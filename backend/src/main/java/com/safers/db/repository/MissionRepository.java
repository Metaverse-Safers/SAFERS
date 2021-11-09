package com.safers.db.repository;

import com.safers.db.entity.unity.Mission;
import com.safers.db.entity.unityLog.MissionLogID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends JpaRepository<Mission, String> {

}
