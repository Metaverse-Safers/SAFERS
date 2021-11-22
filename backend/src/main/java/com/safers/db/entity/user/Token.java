package com.safers.db.entity.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.safers.db.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="token", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"userId"})
public class Token implements Serializable{

    @Id
    String id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id") // 외래키 컬럼의 이름, 매핑할 컬럼의 이름
    User userId;

    @Column(name = "refresh_token")
    String refreshToken;

    @Column(name = "access_token")
    String accessToken;

}
