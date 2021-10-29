package com.safers.api.service;

import com.safers.api.request.BoardCommentPostRequest;
import com.safers.api.request.BoardRegisterPostRequest;
import com.safers.api.response.BoardGetResponse;
import com.safers.common.util.RandomIdUtil;
import com.safers.db.entity.board.Board;
import com.safers.db.entity.board.BoardComment;
import com.safers.db.entity.board.BoardImage;
import com.safers.db.entity.user.User;
import com.safers.db.repository.BoardCommentRepository;
import com.safers.db.repository.BoardImageRepository;
import com.safers.db.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    UserService userService;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardImageRepository boardImageRepository;

    @Autowired
    BoardCommentRepository boardCommentRepository;

    @Autowired
    S3Service s3Service;

    /**
     * 게시글 전체 목록 조회 (삭제 처리 x)
     * @param page
     * @return List<BoardGetResponse> 
     */
    public List<BoardGetResponse> findBoardListByPage(int page) {
        PageRequest pageRequest = PageRequest.of(page, 30, Sort.Direction.DESC, "regDt");
        List<BoardGetResponse> boardGetResponseList = new ArrayList<>();
        Page<Board> boardPage = boardRepository.findAllByIsDeleteEquals(false, pageRequest);
        for(Board board : boardPage) {
            System.out.println("board >> " + board.getTitle());
            Optional<List<String>> fileList = boardImageRepository.findAllFilePathByBoardEquals(board.getId());
            if(fileList.isPresent())
                boardGetResponseList.add(BoardGetResponse.of(board,fileList.get()));
        }
        return boardGetResponseList;
    }

    /**
     * 게시글 등록
     * @param boardRegisterPostRequest
     * @return Board
     */
    public Board registerBoard(BoardRegisterPostRequest boardRegisterPostRequest) throws IOException {
        Board board = new Board();
        String id = "";

        // 새로운 board id 생성
        while(true) {
            id = RandomIdUtil.makeRandomId(13);
            Optional<Board> tmpBoard = boardRepository.findById(id);
            if(!tmpBoard.isPresent()) break;
        }
        board.setId(id);
        // user -> id로 User 정보 가져오기
        Optional<User> user = userService.getUserById(boardRegisterPostRequest.getUserId());
        board.setUser(user.get());
        board.setTitle(boardRegisterPostRequest.getTitle());
        board.setContent(boardRegisterPostRequest.getContent());
        board.setIsDelete(false);
        boardRepository.save(board);

        for(MultipartFile multipartFile : boardRegisterPostRequest.getFileList()) {
            BoardImage image = new BoardImage();
            String saveUrl = s3Service.upload(multipartFile, "board");
            image.setBoard(board);
            image.setFileName(saveUrl);
            // image.setFilePath("https://"+S3Service"/"+saveUrl);
            boardImageRepository.save(image);
        }
        return board;
    }

    /**
     * 상세 글 정보 가져오기 / 댓글 정보는 없음
     * @param boardId
     * @return BoardGetResponse
     */
    public BoardGetResponse findBoard(String boardId) {
        Board board = boardRepository.getById(boardId);
        Optional<List<String>> fileList = boardImageRepository.findAllFilePathByBoardEquals(boardId);
//        if(fileList.isPresent())
//            return BoardGetResponse.of(board, fileList.get());
//        return null;
        return BoardGetResponse.of(board, fileList.get());
    }

    /**
     * 게시글 수정하기
     * @param boardId
     * @param boardRegisterPostRequest
     * @return Board
     */
    public Board updateBoard(String boardId, BoardRegisterPostRequest boardRegisterPostRequest) {
        Board board = boardRepository.getById(boardId);
        return board;
    }

    /**
     * 게시글 삭제하기
     * @param boardId
     * @return Board
     */
    public Board deleteBoard(String boardId) {
        Board board = new Board();
        return board;
    }

    public List<BoardGetResponse> findBoardListByPageAndUserId(int page, String userId) {
        List<BoardGetResponse> boardGetResponseList = new ArrayList<>();
        return boardGetResponseList;
    }

    /**
     * 댓글 등록
     * @param boardId
     * @param boardCommentPostRequest
     * @return BoardComment
     */
    public BoardComment registerBoardComment(String boardId, BoardCommentPostRequest boardCommentPostRequest) {
        BoardComment boardComment = new BoardComment();
        String id = "";
        // 새로운 board id 생성
        while(true) {
            id = RandomIdUtil.makeRandomId(13);
            Optional<BoardComment> tmpBoard = boardCommentRepository.findById(id);
            if(!tmpBoard.isPresent()) break;
        }
        boardComment.setId(id);
        boardComment.setUserId(boardCommentPostRequest.getUserId());
        boardComment.setComment(boardCommentPostRequest.getComment());
        boardComment.setIsDelete(false);
        Optional<Board> board = boardRepository.findById(boardId);
        if(!board.isPresent()) return null;
        boardComment.setBoard(board.get());
        boardCommentRepository.save(boardComment);

        return boardComment;
    }

}