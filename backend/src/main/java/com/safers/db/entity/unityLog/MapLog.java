package com.safers.db.entity.unityLog;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.safers.db.entity.unity.Map;
import com.safers.db.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="map_log", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(MapLog.class)
public class MapLog implements Serializable {
    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="user_id")
    User user;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="map_id")
    Map map;

    @Column(name="reg_dt", columnDefinition = "TIMESTAMP")
    Date regDt;
}
