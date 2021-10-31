package com.safers.api.controller;

import com.safers.api.request.BoardCommentPostRequest;
import com.safers.api.request.BoardRegisterPostRequest;
import com.safers.api.response.BaseResponse;
import com.safers.api.response.BoardCommentGetResponse;
import com.safers.api.response.BoardGetResponse;
import com.safers.api.service.BoardService;
import com.safers.db.entity.board.Board;
import com.safers.db.entity.board.BoardComment;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    @GetMapping("/list/{page}")
    public ResponseEntity<List<BoardGetResponse>> findBoardListByPage(@PathVariable("page") int page) {
        List<BoardGetResponse> boardList = boardService.findBoardListByPage(page);
        return new ResponseEntity<>(boardList, HttpStatus.OK);
    }


    @ApiOperation(value = "게시글 등록", notes="사용자가 입력한 데이터대로 게시글을 등록한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "게시글 등록 성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 에러 발생")
    })
    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<? extends BaseResponse> registerBoard(@ModelAttribute BoardRegisterPostRequest boardRegisterPostRequest) throws IOException {
        Board board = boardService.registerBoard(boardRegisterPostRequest);

        System.out.println(board);
        return new ResponseEntity<>(BaseResponse.of(200, "게시글이 정상적으로 등록되었습니다"), HttpStatus.OK);
    }

    @ApiOperation(value = "게시글 가져오기", notes="사용자가 선택한 게시글을 가져온다. 댓글 정보는 없음")
    @ApiResponses({
            @ApiResponse(code = 200, message = "선택 게시글 조회 성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 에러 발생")
    })
    @GetMapping("/{board_id}")
    public ResponseEntity<BoardGetResponse> findBoard(@PathVariable(value = "board_id")String boardId) throws IOException {
        BoardGetResponse board = boardService.findBoard(boardId);

        System.out.println(board);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }


    @ApiOperation(value = "게시글 수정하기", notes="게시글을 수정한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "선택 게시글 수정 성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 에러 발생")
    })
    @PatchMapping(value = "/{board_id}",consumes = {"multipart/form-data"})
    public ResponseEntity<? extends BaseResponse> updateBoard(@PathVariable(value = "board_id")String boardId, @ModelAttribute BoardRegisterPostRequest boardRegisterPostRequest) throws IOException {
        Board board = boardService.updateBoard(boardId, boardRegisterPostRequest);

        System.out.println(board);
        return new ResponseEntity<>(BaseResponse.of(200, "게시글이 정상적으로 수정되었습니다"), HttpStatus.OK);
    }


    @ApiOperation(value = "게시글 삭제하기", notes="게시글 내 is_delete를 true로 변경하여 게시글 삭제 처리한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "선택 게시글 삭제 성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 에러 발생")
    })
    @PatchMapping(value = "/delete/{board_id}")
    public ResponseEntity<? extends BaseResponse> deleteBoard(@PathVariable(value = "board_id")String boardId) throws IOException {
        Board board = boardService.deleteBoard(boardId);

        System.out.println(board);
        return new ResponseEntity<>(BaseResponse.of(200, "게시글이 정상적으로 수정되었습니다"), HttpStatus.OK);
    }

    @ApiOperation(value = "내가 쓴 글 목록 조회", notes="특정 사용자가 작성한 게시글 중 삭제처리가 되지 않은 게시글 전체 목록을 조회한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "내가 쓴 게시글 전체 목록 조회 성공"),
            @ApiResponse(code = 204, message = "조회할 데이터가 없음"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 에러 발생")
    })
    @GetMapping("/{page}/{user_id}")
    public ResponseEntity<List<BoardGetResponse>> findBoardListByPageAndUserId(@PathVariable("page") int page, @PathVariable("user_id") String userId) {
        List<BoardGetResponse> boardList = boardService.findBoardListByPageAndUserId(page, userId);
        return new ResponseEntity<>(boardList, HttpStatus.OK);
    }

    @ApiOperation(value = "게시글 댓글 등록", notes="특정 게시글에 댓글 작성")
    @ApiResponses({
            @ApiResponse(code = 200, message = "댓글 등록 성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 에러 발생")
    })
    @PostMapping("/comment/{board_id}")
    public ResponseEntity<? extends BaseResponse> registerBoardComment(@PathVariable("board_id") String boardId, @ApiParam(value="게시글 댓글 정보", required = true) BoardCommentPostRequest boardCommentPostRequest) throws IOException {
        BoardComment boardComment = boardService.registerBoardComment(boardId, boardCommentPostRequest);

        return new ResponseEntity<>(BaseResponse.of(200, "댓글이 정상적으로 등록되었습니다"), HttpStatus.OK);
    }

    @ApiOperation(value = "게시글 댓글 수정", notes="특정 게시글에 댓글 수정")
    @ApiResponses({
            @ApiResponse(code = 200, message = "댓글 수정 성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 에러 발생")
    })
    @PatchMapping("/comment/{comment_id}")
    public ResponseEntity<? extends BaseResponse> updateBoardComment(@PathVariable("comment_id") String commentId, @ApiParam(value="게시글 댓글 정보", required = true) @RequestBody @ModelAttribute BoardCommentPostRequest boardCommentPostRequest) throws IOException {
        System.out.println("댓글 수정하러 가기 >> 댓글 아이디 " + commentId + " // 수정할 내용 : " + boardCommentPostRequest.getComment() + " // 유저 아이디 : " + boardCommentPostRequest.getUserId());
        BoardComment boardComment = boardService.updateBoardComment(commentId, boardCommentPostRequest);

        return new ResponseEntity<>(BaseResponse.of(200, "댓글이 정상적으로 수정되었습니다"), HttpStatus.OK);
    }

    @ApiOperation(value = "게시글 댓글 삭제", notes="특정 게시글 댓글 삭제")
    @ApiResponses({
            @ApiResponse(code = 200, message = "댓글 삭제 성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 에러 발생")
    })
    @PatchMapping("/comment/delete/{comment_id}")
    public ResponseEntity<? extends BaseResponse> deleteBoardComment(@PathVariable("comment_id") String commentId) throws IOException {
        BoardComment boardComment = boardService.deleteBoardComment(commentId);

        return new ResponseEntity<>(BaseResponse.of(200, "댓글이 정상적으로 삭제되었습니다"), HttpStatus.OK);
    }

    @ApiOperation(value = "게시글 댓글 목록", notes="특정 게시글의 목록 가져오기")
    @ApiResponses({
            @ApiResponse(code = 200, message = "댓글 목록 가져오기 성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 에러 발생")
    })
    @GetMapping("/comment/{board_id}")
    public ResponseEntity<List<BoardCommentGetResponse>> findBoardCommentList(@PathVariable("board_id") String boardId) throws IOException {
        List<BoardCommentGetResponse> boardServiceBoardCommentList = boardService.findBoardCommentList(boardId);

        return new ResponseEntity<>(boardServiceBoardCommentList, HttpStatus.OK);
    }
}