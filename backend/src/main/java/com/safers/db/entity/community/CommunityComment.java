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
@Table(name="community_comment", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommunityComment extends BaseEntity {
    @Column(name = "comment")
    String comment;

    @Column(name="user_id")
    String userId;

    @Column(name = "nick_name")
    String nickName;

    @Column(name = "reg_dt")
    Date regDt;

    @Column(name = "is_delete")
    boolean isDelete;

    @JoinColumn(name="community_id")
    String communityId;
}
