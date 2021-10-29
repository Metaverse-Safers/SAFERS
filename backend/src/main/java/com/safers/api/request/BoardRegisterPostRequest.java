package com.safers.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ApiModel("BoardRegisterPostRequest")
public class BoardRegisterPostRequest {

    @ApiModelProperty
    String userId;

    @ApiModelProperty
    String title;

    @ApiModelProperty
    String content;

    @ApiModelProperty
    LocalDateTime regDt;

    @ApiModelProperty
    List<MultipartFile> fileList;

    @Override
    public String toString() {
        return "BoardRegisterPostRequest{" +
                "userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", regDt='" + regDt + '\'' +
                ", fileList=" + fileList +
                '}';
    }


}
