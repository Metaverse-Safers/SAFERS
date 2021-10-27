package com.safers.db.entity.unity;

import com.safers.db.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="mission", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Column(name = "name")
    String mapName;

    @Column(name="title")
    String title;

    @Column(name="result_id")
    String resultId;

    @JoinColumn(name="code")
    String code;
}
