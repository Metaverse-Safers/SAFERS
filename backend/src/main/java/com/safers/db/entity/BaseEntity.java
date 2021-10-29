package com.safers.db.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@MappedSuperclass
public class BaseEntity {
    @Id
    @Column(length = 13)
    String id;
}
