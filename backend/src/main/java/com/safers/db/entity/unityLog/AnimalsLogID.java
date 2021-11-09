package com.safers.db.entity.unityLog;

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
public class AnimalsLogID implements Serializable {
    private String user; // User의 PK
    private String animals; // Animals의 PK
}
