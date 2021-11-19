package com.safers.db.entity.unityLog;

import com.safers.db.entity.unity.Mission;
import com.safers.db.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
    MissionLog 테이블의 복합키를 담고 있는 식별자 클래스
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissionLogID implements Serializable {
    private String user; // User의 PK
    private String mission; // Mission의 PK
}
