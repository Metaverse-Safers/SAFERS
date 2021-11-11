package com.safers.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="survey", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Survey {
    @Id
    @Column(name="mbti", length = 5)
    String mbti;

    @Column(name="area", length = 30)
    String area;

    @Column(name="name", columnDefinition = "TEXT")
    String name;

    @Column(name="image_url", length = 200)
    String imageUrl;

    @Column(name="introduce", columnDefinition = "TEXT")
    String introduce;

    @Column(name="explanation", columnDefinition = "TEXT")
    String explanation;

    @Column(name="extinction", columnDefinition = "TEXT")
    String extinction;

    @Column(name="personality", columnDefinition = "TEXT")
    String personality;

    @Column(name="buddy", columnDefinition = "TEXT")
    String buddy;

    @Column(name="enemy", columnDefinition = "TEXT")
    String enemy;
}
