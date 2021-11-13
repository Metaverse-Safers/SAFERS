package com.safers.db.entity.unity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.safers.db.entity.BaseEntity;
import com.safers.db.entity.unityLog.MissionLog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="mission", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Column(name="title", columnDefinition = "TEXT")
    String title;

    @Column(name="result_id", columnDefinition = "TEXT")
    String resultId;

    @Column(name="next_mission", columnDefinition = "TEXT")
    String nextMission;

    @Column(name="animal_name", columnDefinition = "TEXT")
    String animalName;

    @JsonManagedReference
    @OneToMany(mappedBy = "mission", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    List<MissionLog> Mission;
}
