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
@Table(name="community_image", schema = "safers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommunityImage extends BaseEntity {
    @Column(name = "file_path")
    String filePath;

    @Column(name="file_name")
    String fileName;

    @JoinColumn(name="community_id")
    String communityId;
}
