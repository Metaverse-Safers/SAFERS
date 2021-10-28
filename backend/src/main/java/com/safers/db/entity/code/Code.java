package com.safers.db.entity.code;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.safers.db.entity.unity.Mission;
import com.safers.db.entity.unityLog.MissionLog;
import com.safers.db.entity.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "code", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Code {

    @Id
    @Column(name="code", length = 3)
    String code;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="common_code")
    CommonCode commonCode;

    @Column(name="name", length = 15)
    String name;

    @Column(name="use_yn")
    boolean useYn;

    @JsonIgnore
    @OneToMany(mappedBy="code", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    private List<User> user;

    @JsonIgnore
    @OneToMany(mappedBy="code", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    private List<MissionLog> missionLog;

    @JsonIgnore
    @OneToMany(mappedBy="code", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    private List<Mission> mission;
}
