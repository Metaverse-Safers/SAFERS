package com.safers.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="token", schema = "safer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Token extends BaseEntity{

    @OneToOne
    @JoinColumn(name = "id")
    User userId;

    @Column(name = "refresh_token")
    String refreshToken;

    @Column(name = "access_token")
    String accessToken;

}
