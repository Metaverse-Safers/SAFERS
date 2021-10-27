package com.safers.db.entity.unityLog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="map_log", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(MapLog.class)
public class MapLog implements Serializable {
    @Id
    @JoinColumn(name="user_id")
    String userId;

    @Id
    @JoinColumn(name="map_id")
    String mapId;

    @Column(name="reg_dt")
    Date regDt;
}
