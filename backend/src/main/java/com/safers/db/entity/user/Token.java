package com.safers.db.entity.user;

import com.safers.db.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="token", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Token extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "id")
    User userId;

    @Column(name = "refresh_token")
    String refreshToken;

    @Column(name = "access_token")
    String accessToken;

}
