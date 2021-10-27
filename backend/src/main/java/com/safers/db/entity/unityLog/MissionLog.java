package com.safers.db.entity.unityLog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="mission_log", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(MissionLog.class)
public class MissionLog implements Serializable {
    @Id
    @JoinColumn(name="user_id")
    String userId;

    @Id
    @JoinColumn(name="mission_id")
    String missionId;

    @Column(name="reg_dt")
    Date regDt;
}
