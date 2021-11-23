package com.safers.db.entity.code;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="common_code", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonCode{

    @Id
    @Column(name="common_code", length = 3)
    String commonCode;

    @Column(name="name", length = 15)
    String name;

    @JsonManagedReference
    @OneToMany(mappedBy="commonCode", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    List<Code> code;

}
