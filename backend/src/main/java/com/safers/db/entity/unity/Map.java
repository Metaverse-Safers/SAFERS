package com.safers.db.entity.unity;

import com.safers.db.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="map", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Map extends BaseEntity {
    @Column(name = "name")
    String mapName;
}
