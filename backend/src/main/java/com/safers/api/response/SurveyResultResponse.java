package com.safers.api.response;

import com.safers.api.service.SurveyService;
import com.safers.db.entity.Survey;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@Getter
@Setter
@Builder
public class SurveyResultResponse extends BaseResponse{
    @ApiModelProperty
    String mbti;

    @ApiModelProperty
    String area;

    @ApiModelProperty
    String name;

    @ApiModelProperty
    String imageUrl;

    @ApiModelProperty
    String introduce;

    @ApiModelProperty
    List<String> explanation;

    @ApiModelProperty
    List<String> extinction;

    @ApiModelProperty
    List<String> personality;

    @ApiModelProperty
    List<SurveySimpleResponse> buddy;

    @ApiModelProperty
    List<SurveySimpleResponse> enemy;

    @ApiModelProperty
    List<SurveySimpleResponse> similar;

    public static SurveyResultResponse of(Integer statusCode, String message, SurveyResultResponse survey){
        survey.setStatusCode(statusCode);
        survey.setStatusMessage(message);
        return survey;
    }


}
