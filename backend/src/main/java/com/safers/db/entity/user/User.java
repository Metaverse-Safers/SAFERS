package com.safers.db.entity.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.safers.db.entity.BaseEntity;
import com.safers.db.entity.code.Code;
import com.safers.db.entity.unityLog.AnimalsLog;
import com.safers.db.entity.unityLog.MapLog;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="user", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity implements Serializable{

    @Column(name = "profile_url")
    String profileUrl;

    @Column(name = "kakao_id")
    Long kakaoId;

    @Column(name = "nick_name", length = 15)
    String nickName;

    @ManyToOne
    @JoinColumn(name = "code")
    Code code;

    @JsonIgnore
    @OneToMany(mappedBy="user", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    private List<MapLog> mapLog;

    @JsonIgnore
    @OneToMany(mappedBy="user", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    private List<AnimalsLog> animalsLog;

}
