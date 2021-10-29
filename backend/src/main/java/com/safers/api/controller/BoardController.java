package com.safers.api.controller;

import com.safers.api.response.BoardGetResponse;
import com.safers.api.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@Api(value = "BoardController", tags = "BoardController",
        description="게시판 관련 컨트롤러")
public class BoardController {

    @Autowired
    BoardService boardService;

    @ApiOperation(value = "게시판 전체 목록 조회", notes="사용자들이 등록한 게시글 중 삭제처리가 되지 않은 게시글 전체 목록을 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "게시글 전체 목록 조회 성공"),
            @ApiResponse(code = 204, message = "조회할 데이터가 없음"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 에러 발생")
    })
    @GetMapping("/{page}")
    public ResponseEntity<List<BoardGetResponse>> findBoardListByPage(@PathVariable("page") int page) {
        List<BoardGetResponse> boardList = boardService.findBoardListByPage(page);
        return new ResponseEntity<>(boardList, HttpStatus.OK);
    }

}