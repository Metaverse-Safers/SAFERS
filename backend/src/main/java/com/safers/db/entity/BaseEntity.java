package com.safers.db.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class BaseEntity {
    @Id
    @Column(length = 13)
    String id;
}
