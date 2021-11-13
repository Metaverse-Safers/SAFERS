package com.safers.api.controller;

import com.safers.api.request.UserProfileRequest;
import com.safers.api.request.UserTokenRequest;
import com.safers.api.response.UserPresentResponse;
import com.safers.api.response.UserResponse;
import com.safers.api.response.UserTokenResponse;
import com.safers.api.service.BoardService;
import com.safers.api.service.KakaoService;
import com.safers.api.service.UnityService;
import com.safers.api.service.UserService;
import com.safers.db.entity.board.Board;
import com.safers.db.entity.board.BoardComment;
import com.safers.db.entity.user.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static java.util.Objects.isNull;

/**
 * 사용자 관련 API 요청처리를 위한 컨트롤러
 */
@Api(value = "사용자 API", tags = "User")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    KakaoService kakaoService;
    @Autowired
    UnityService unityService;
    @Autowired
    BoardService boardService;

    @GetMapping("/token")
    @ApiOperation(value = "Token 요청", notes = "발급된 code로 사용자의 Token을 발급한다.")
    public ResponseEntity<UserTokenResponse> requestAuthCode(@RequestParam(value = "code") String code) {
        // code값을 이용한 accessToken 조회
        HashMap<String, String> token = kakaoService.getTokens(code);
        String accessToken = token.get("accessToken");
        String refreshToken = token.get("refreshToken");

        return ResponseEntity.ok(UserTokenResponse.of(accessToken, refreshToken));
    }

    @PostMapping("/token/refresh")
    @ApiOperation(value = "Token 갱신 요청", notes = "refreshToken을 통해 만료된 AccessToken을 갱신한다.")
    public ResponseEntity<UserTokenResponse> refreshAccessToken(@RequestBody UserTokenRequest request) {
        HashMap<String, String> token = kakaoService.refreshTokens(request.getRefreshToken());
        String accessToken = token.get("accessToken");

        return ResponseEntity.ok(UserTokenResponse.of(accessToken, request.getRefreshToken()));
    }

    @PostMapping("/present")
    @ApiOperation(value = "회원 조회", notes = "해당 회원이 존재하는 회원인지 판단한다.")
    public ResponseEntity<UserPresentResponse> isPresentUser(@RequestBody UserTokenRequest request) {
        String accessToken = request.getAccessToken();
        String refreshToken = request.getRefreshToken();

        // accessToken을 이용한 사용자 정보 조회
        HashMap<String, Object> profile = kakaoService.getUserProfile(accessToken, refreshToken);

        // 해당 회원이 사이트에 가입한 기록이 있는지 체크
        Long kakaoId = (Long) profile.get("kakaoId");
        String profileUrl = (String) profile.get("profileUrl");
        String nickname = (String) profile.get("nickname");
        User user = userService.getUserByKakaoId(kakaoId);

        // 1. 회원가입이 되어있지 않은 경우 -> id로 빈문자열 전달
        if (isNull(user)){
            return ResponseEntity.ok(UserPresentResponse.of(false, UserResponse.of("", nickname, profileUrl)));
        }
        // 2. 탈퇴회원인 경우 -> id로 기존 회원의 id 전달
        else if("A02".equals(user.getCode().getCode())){
            return ResponseEntity.ok(UserPresentResponse.of(false, UserResponse.of(user.getId(), nickname, profileUrl)));
        }
        // 3. 일반회원인 경우
        return ResponseEntity.ok(UserPresentResponse.of(true, UserResponse.of(user.getId(), user.getNickName(), user.getProfileUrl())));
    }


    @PostMapping("/login")
    @ApiOperation(value = "카카오 로그인", notes = "로그인 후, 사용자 정보를 반환한다.")
    public ResponseEntity<UserResponse> login(@RequestBody UserTokenRequest request) {

        String accessToken = request.getAccessToken();
        String refreshToken = request.getRefreshToken();

        // accessToken을 이용한 사용자 정보 조회
        HashMap<String, Object> profile = kakaoService.getUserProfile(accessToken, refreshToken);

        // 해당 회원이 사이트에 가입한 기록이 있는지 체크
        Long kakaoId = (Long) profile.get("kakaoId");
        String profileUrl = (String) profile.get("profileUrl");
        User user = userService.getUserByKakaoId(kakaoId);

        // 1. 회원가입이 되어있지 않은 경우, 회원 정보 저장
        if(isNull(user)) {
            user = userService.createUser(accessToken, refreshToken, profile);
            unityService.createMissionLog(user);
            unityService.createMapLog(user);
        }
        // 2. 탈퇴회원인 경우, code만 변경
        else if("A02".equals(user.getCode().getCode())) {
            user.setProfileUrl(profileUrl);
            user = userService.reconnectUser(user);
            unityService.createMissionLog(user);
            unityService.createMapLog(user);
        }

        // accessToken과 refreshToken 저장
        userService.saveToken(user, accessToken, refreshToken);

        return ResponseEntity.ok(UserResponse.of(user));
    }

    @GetMapping("/logout")
    @ApiOperation(value = "카카오 로그아웃", notes = "사용자의 token을 만료 시킨 후, 로그아웃한다.")
    public ResponseEntity<String> logout(@RequestHeader(value = "authorization") String accessToken) {
        kakaoService.logout(accessToken);
        return ResponseEntity.ok("로그아웃 되었습니다.");
    }

    @DeleteMapping("/")
    @ApiOperation(value = "카카오 회원 탈퇴", notes = "사용자의 token을 만료 시키고 회원상태 값을 'A02'(탈퇴 회원)로 변경한다.")
    public ResponseEntity<String> disconnect(@RequestHeader(value = "authorization") String accessToken) {

        Long kakaoId = kakaoService.disconnect(accessToken);
        User user = userService.getUserByKakaoId(kakaoId);
        userService.disconnectUser(user);
        userService.deleteToken(user);
        unityService.deleteMissionLog(user);
        
        // 게시글 is_delete 처리
        List<Board> boardList = boardService.findBoardListByUserId(user);
        for(Board board : boardList) {
            boardService.deleteBoard(board.getId());
        }
        
        // 댓글 is_delete 처리
        List<BoardComment> boardCommentList = boardService.findBoardCommentByUserId(user.getId());
        for(BoardComment boardComment : boardCommentList) {
            boardService.deleteBoardComment(boardComment.getId());
        }

        // animal log 지우기
        unityService.deleteAnimalLog(user);
        // map log 지우기
        unityService.deleteMapLog(user);

        return ResponseEntity.ok("회원탈퇴 되었습니다.");
    }

    @PostMapping("/")
    @ApiOperation(value = "회원 프로필 수정", notes = "회원의 프로필을 수정한다.")
    public ResponseEntity<UserResponse> updateUserProfile(MultipartHttpServletRequest request) throws IOException {

        String id = request.getParameter("id");
        String nickName = request.getParameter("nickName");
        MultipartFile profileFile = request.getFile("profileFile");

        UserProfileRequest profile = UserProfileRequest.builder().id(id).nickName(nickName).profileFile(profileFile).build();

        User user = userService.updateUser(profile);
        return ResponseEntity.ok(UserResponse.of(user));
    }
}