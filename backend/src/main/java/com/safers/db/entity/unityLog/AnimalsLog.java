package com.safers.db.entity.unityLog;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.safers.db.entity.unity.Animals;
import com.safers.db.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="animals_log", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@IdClass(AnimalsLogID.class)
public class AnimalsLog implements Serializable {
    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="user_id")
    User user;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="animals_id")
    Animals animals;

    @CreatedDate
    @Column(name="reg_dt", columnDefinition = "TIMESTAMP")
    LocalDateTime regDt;
}
