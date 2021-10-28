package com.safers.db.entity.unity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.safers.db.entity.BaseEntity;
import com.safers.db.entity.unityLog.MapLog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="map", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Map extends BaseEntity {
    @Column(name = "name", length = 30)
    String mapName;

    @JsonManagedReference
    @OneToMany(mappedBy = "map", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    List<Animals> animals;

    @JsonManagedReference
    @OneToMany(mappedBy = "map", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    List<MapLog> mapLog;
}
