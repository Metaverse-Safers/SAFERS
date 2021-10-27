package com.safers.db.entity.community;

import com.safers.db.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="community", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Community extends BaseEntity {
    @JoinColumn(name="user_id")
    String userId;

    @Column(name = "title")
    String title;

    @Column(name = "content")
    String content;

    @Column(name = "reg_dt")
    Date regDt;

    @Column(name = "is_delete")
    boolean isDelete;
}
