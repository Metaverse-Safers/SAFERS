package com.safers.db.entity.code;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="code", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Code {

    @Id
    @Column(name="code")
    String code;

    @JoinColumn(name="common_code")
    String commonCode;

    @Column(name="name")
    String name;

    @Column(name="use_yn")
    boolean useYn;
}
