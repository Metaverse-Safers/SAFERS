package com.safers.db.entity.unity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.safers.db.entity.BaseEntity;
import com.safers.db.entity.unityLog.AnimalsLog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="animals", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"map"})
public class Animals extends BaseEntity {
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="map_id")
    Map map;

    @Column(name = "name", length = 30)
    String animalsName;

    @JsonManagedReference
    @OneToMany(mappedBy = "animals", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    List<AnimalsLog> animalsLog;
}
