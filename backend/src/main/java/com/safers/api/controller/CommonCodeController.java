package com.safers.api.controller;

import com.safers.api.response.BoardGetResponse;
import com.safers.api.service.CommonCodeService;
import com.safers.db.entity.code.CommonCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/commoncode")
@Api(value = "CommonCodeController", tags = "CommonCodeController",
        description="공통 코드 관련 컨트롤러")
public class CommonCodeController {

    @Autowired
    CommonCodeService commonCodeService;

    @ApiOperation(value = "카테고리 목록 조회", notes="서비스에 존재하는 게시판의 카테고리 호출")
    @ApiResponses({
            @ApiResponse(code = 200, message = "카테고리 목록 조회 성공"),
            @ApiResponse(code = 204, message = "조회할 데이터가 없음"),
            @ApiResponse(code = 401, message = "조회 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 에러 발생")
    })
    @GetMapping("/category")
    public ResponseEntity<List<CommonCode>> findBoardListByPage() {
        List<CommonCode> boardList = commonCodeService.findCommonCode("D");
        return new ResponseEntity<>(boardList, HttpStatus.OK);
    }
}
