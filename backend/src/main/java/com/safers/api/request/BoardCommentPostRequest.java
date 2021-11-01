package com.safers.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("BoardCommentPostRequest")
public class BoardCommentPostRequest {

    @ApiModelProperty
    String comment;

    @ApiModelProperty
    String userId;

    @Override
    public String toString() {
        return "BoardCommentPostRequest{" +
                "comment='" + comment + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
