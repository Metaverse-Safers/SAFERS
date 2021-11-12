package com.safers.api.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SurveySimpleResponse {

    @ApiModelProperty
    String name;

    @ApiModelProperty
    String imageUrl;


}
