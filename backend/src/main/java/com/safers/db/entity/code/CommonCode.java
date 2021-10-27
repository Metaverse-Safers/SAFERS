package com.safers.db.entity.code;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="common_code", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonCode{

    @Id
    @Column(name="common_code")
    String commonCode;

    @Column(name="name")
    String name;
}
