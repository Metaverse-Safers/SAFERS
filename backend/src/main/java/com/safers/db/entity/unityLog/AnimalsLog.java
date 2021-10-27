package com.safers.db.entity.unityLog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="animals_log", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(AnimalsLog.class)
public class AnimalsLog implements Serializable {
    @Id
    @JoinColumn(name="user_id")
    String userId;

    @Id
    @JoinColumn(name="animals_id")
    String animalsId;

    @Column(name="reg_dt")
    Date regDt;
}
