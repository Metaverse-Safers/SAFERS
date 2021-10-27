package com.safers.db.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    String id; // 사용자의 kakao ID

    @Column(name = "profile_url")
    String profileUrl;

    @Column(name = "kakao_id")
    Long kakaoId;

    @Column(name = "nick_name")
    String nickName;

    @Column(name = "code")
    String code;
}
