package com.safers.api.controller;

import com.safers.api.response.BaseResponse;
import com.safers.api.response.SurveyResultResponse;
import com.safers.api.service.SurveyService;
import com.safers.db.entity.Survey;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/survey")
@Api(value = "SurveyController", tags = "SurveyController",
        description="설문조사 관련 컨트롤러")
public class SurveyController {

    @Autowired
    SurveyService surveyService;

    @ApiOperation(value = "설문 결과 조회", notes="사용자들의 성격유형검사 결과를 조회다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "설문 결과 조회 성공"),
            @ApiResponse(code = 204, message = "조회할 데이터가 없음"),
            @ApiResponse(code = 401, message = "조회 실패"),
            @ApiResponse(code = 404, message = "기준 없음"),
            @ApiResponse(code = 500, message = "서버 에러 발생")
    })
    @GetMapping("/{mbti}")
    public ResponseEntity<? extends BaseResponse> findMbtiData(@PathVariable("mbti") String mbti) {
        SurveyResultResponse surver = surveyService.findMbtiData(mbti);
        if(surver == null)
            return ResponseEntity.status(404).body(BaseResponse.of(404, "설문 결과 조회 실패"));
        return ResponseEntity.status(200).body(SurveyResultResponse.of(200, "설문 결과 조회 성공", surver));
    }
}
