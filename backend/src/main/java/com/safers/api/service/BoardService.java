package com.safers.api.service;

import com.safers.api.request.BoardCommentPostRequest;
import com.safers.api.request.BoardRegisterPostRequest;
import com.safers.api.response.BoardCommentGetResponse;
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

import static java.util.Objects.isNull;

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
     * 게시글 전체 목록 조회 (삭제 처리 x) : 완료 (O)
     * @param page
     * @return List<BoardGetResponse> 
     */
    public List<BoardGetResponse> findBoardListByPage(int page) {
        PageRequest pageRequest = PageRequest.of(page, 30, Sort.Direction.DESC, "regDt");
        List<BoardGetResponse> boardGetResponseList = new ArrayList<>();
        Page<Board> boardPage = boardRepository.findAllByIsDeleteEquals(false, pageRequest);
        return getBoardGetResponses(boardGetResponseList, boardPage);
    }

    /**
     * 게시글 등록 : 완료
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
        User user = userService.getUserById(boardRegisterPostRequest.getUserId());
        board.setUser(user);
        board.setTitle(boardRegisterPostRequest.getTitle());
        board.setContent(boardRegisterPostRequest.getContent());
        board.setIsDelete(false);
        boardRepository.save(board);


        for(MultipartFile multipartFile : boardRegisterPostRequest.getFileList()) {
            BoardImage image = new BoardImage();
            System.out.println("등록된 사진 >> " + multipartFile.getOriginalFilename());
            while(true) {
                id = RandomIdUtil.makeRandomId(13);
                Optional<BoardImage> tmpBoardImage = boardImageRepository.findById(id);
                if(!tmpBoardImage.isPresent()) break;
            }
            image.setId(id);
            String saveUrl = s3Service.upload(multipartFile, "board");
            System.out.println("S3에 등록할 URL >> "+saveUrl);
            image.setBoard(board);
            image.setFileName(multipartFile.getOriginalFilename());
            image.setFilePath(saveUrl);
            // image.setFilePath("https://"+S3Service"/"+saveUrl);
            boardImageRepository.save(image);
        }

        return board;
    }

    /**
     * 상세 글 정보 가져오기 / 댓글 정보는 없음 : 완료 (O)
     * @param boardId
     * @return BoardGetResponse
     */
    public BoardGetResponse findBoard(String boardId) {
        Board board = boardRepository.getById(boardId);
        Optional<List<BoardImage>> fileList = boardImageRepository.findBoardImagesByBoardEquals(board);
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
    public Board updateBoard(String boardId, BoardRegisterPostRequest boardRegisterPostRequest) throws IOException{
        Board board = boardRepository.getById(boardId);

        if(board != null) {
            String id = "";
            // 기존에 있던 이미지 파일 지우기
            System.out.println(">>>>> 기존 이미지 파일 삭제");
            boardImageRepository.deleteAllByBoardEquals(board);

            for(MultipartFile multipartFile : boardRegisterPostRequest.getFileList()) {
                BoardImage image = new BoardImage();
                while(true) {
                    id = RandomIdUtil.makeRandomId(13);
                    Optional<BoardImage> tmpBoardImage = boardImageRepository.findById(id);
                    if(!tmpBoardImage.isPresent()) break;
                }
                image.setId(id);
                String saveUrl = s3Service.upload(multipartFile, "board");
                image.setBoard(board);
                image.setFileName(multipartFile.getOriginalFilename());
                image.setFilePath(saveUrl);
                boardImageRepository.save(image);
            }
            board.setContent(boardRegisterPostRequest.getContent());
            board.setTitle(boardRegisterPostRequest.getTitle());
        }
        return board;
    }


    /**
     * 게시글 삭제하기 -> 완료 (O)
     * @param boardId
     * @return Board
     */
    public Board deleteBoard(String boardId) {
        Board board = boardRepository.getById(boardId);
        if(board == null)
            return null;
        board.setIsDelete(true);
        boardRepository.save(board);
        return board;
    }

    /**
     * 내가 쓴 글 가져오기 : 완료 (O)
     * @param page
     * @param userId
     * @return List<BoardGetResponse>
     */
    public List<BoardGetResponse> findBoardListByPageAndUserId(int page, String userId) {
        List<BoardGetResponse> boardGetResponseList = new ArrayList<>();
        PageRequest pageRequest = PageRequest.of(page, 30, Sort.Direction.DESC, "regDt");
        User user = userService.getUserById(userId);

        if(isNull(user))
            return null;
        Page<Board> boardPage = boardRepository.findAllByIsDeleteEqualsAndUserEquals(false, user, pageRequest);
        return getBoardGetResponses(boardGetResponseList, boardPage);
    }

    /**
     * 반환할 게시글 정보 넣기 (전체 게시글 / 내가 쓴 게시글 조회 시 사용) -> 완료
     * @param boardGetResponseList
     * @param boardPage
     * @return List<BoardGetResponse>
     */
    private List<BoardGetResponse> getBoardGetResponses(List<BoardGetResponse> boardGetResponseList, Page<Board> boardPage) {
        for(Board board : boardPage) {
            Optional<List<BoardImage>> fileList = boardImageRepository.findBoardImagesByBoardEquals(board);
            if(fileList.isPresent())
                boardGetResponseList.add(BoardGetResponse.of(board,fileList.get()));
        }
        return boardGetResponseList;
    }

    /**
     * 댓글 등록 : 완료 (O)
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

    /**
     * 댓글 수정 : 완료 (O)
     * @param commentId
     * @param boardCommentPostRequest
     * @return BoardComment
     */
    public BoardComment updateBoardComment(String commentId, BoardCommentPostRequest boardCommentPostRequest) {
        BoardComment boardComment = boardCommentRepository.getById(commentId);
        if(boardComment != null) {  // boardComment를 sout하는 순간 에러남 => 왜?
            boardComment.setComment(boardCommentPostRequest.getComment());
            boardCommentRepository.save(boardComment);
            return boardComment;
        }
        return null;
    }

    /**
     * 댓글 삭제 : 완료 (O)
     * @param commentId
     * @return BoardComment
     */
    public BoardComment deleteBoardComment(String commentId) {
        BoardComment boardComment = boardCommentRepository.getById(commentId);
        boardComment.setIsDelete(true);
        boardCommentRepository.save(boardComment);
        return boardComment;
    }

    /**
     * 특정 게시글 댓글 목록 : 완료 (O)
     * @param boardId 
     * @return List<BoardCommentGetResponse>
     */
    public List<BoardCommentGetResponse> findBoardCommentList(String boardId) {
        List<BoardCommentGetResponse> boardCommentGetResponses = new ArrayList<>();
        Board board = boardRepository.getById(boardId);
        Optional<List<BoardComment>> commentList = boardCommentRepository.findAllByBoardEqualsAndIsDeleteEquals(board, false);
        if(!commentList.isPresent())
            return null;
        for(BoardComment boardComment : commentList.get()) {
            User user = userService.getUserById(boardComment.getUserId());
            if(isNull(user)) {
                boardComment.setIsDelete(false);
                continue;
            }
            boardCommentGetResponses.add(BoardCommentGetResponse.of(boardComment, user));
        }
        return boardCommentGetResponses;
    }
}