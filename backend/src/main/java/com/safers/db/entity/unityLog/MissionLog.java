package com.safers.db.entity.unityLog;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.safers.db.entity.code.Code;
import com.safers.db.entity.unity.Mission;
import com.safers.db.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="mission_log", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"user", "mission", "code"})
@IdClass(MissionLogID.class)
public class MissionLog implements Serializable {
    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="user_id")
    User user;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="mission_id")
    Mission mission;

    @Column(name="reg_dt", columnDefinition = "TIMESTAMP")
    LocalDateTime regDt;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "code")
    Code code;
}
