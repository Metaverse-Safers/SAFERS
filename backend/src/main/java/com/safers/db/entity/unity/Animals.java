package com.safers.db.entity.unity;

import com.safers.db.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="animals", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animals extends BaseEntity {
    @JoinColumn(name="map")
    String mapId;

    @Column(name = "name")
    String animalsName;
}
