package com.safers.api.controller;

import com.safers.api.response.UserProfileResponse;
import com.safers.api.response.UserTokenResponse;
import com.safers.api.service.KakaoService;
import com.safers.api.service.UserService;
import com.safers.db.entity.user.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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

    @PostMapping("/token")
    @ApiOperation(value = "Token 요청", notes = "발급된 code로 사용자의 Token을 발급한다.")
    public ResponseEntity<UserTokenResponse> requestAuthCode(@RequestBody HashMap<String, Object> map) {
        String code = (String) map.get("code");

        // code값을 이용한 accessToken 조회
        HashMap<String, String> token = kakaoService.getTokens(code);
        String accessToken = token.get("accessToken");
        String refreshToken = token.get("refreshToken");

        return ResponseEntity.ok(UserTokenResponse.of(accessToken, refreshToken));
    }

    @PostMapping("/token/refresh")
    @ApiOperation(value = "Token 갱신 요청", notes = "refreshToken을 통해 만료된 AccessToken을 갱신한다.")
    public ResponseEntity<UserTokenResponse> refreshAccessToken(@RequestBody HashMap<String, Object> map) {
        String refreshToken = (String)map.get("refreshToken");

        HashMap<String, String> token = kakaoService.refreshTokens(refreshToken);
        String accessToken = token.get("accessToken");

        return ResponseEntity.ok(UserTokenResponse.of(accessToken, refreshToken));
    }

    @PostMapping("/login")
    @ApiOperation(value = "카카오 로그인", notes = "로그인 후, 사용자 정보를 반환한다.")
    public ResponseEntity<UserProfileResponse> login(@RequestBody HashMap<String, Object> map) {

        String accessToken = (String)map.get("accessToken");
        String refreshToken = (String)map.get("refreshToken");

        // accessToken을 이용한 사용자 정보 조회
        HashMap<String, Object> profile = kakaoService.getUserProfile(accessToken, refreshToken);
        Long kakaoId = (Long) profile.get("kakaoId");
        String nickname = (String) profile.get("nickname");
        String profileUrl = (String) profile.get("profileUrl");

        // 해당 회원이 사이트에 가입한 기록이 있는지 체크
        User user = userService.getUserByKakaoId(kakaoId);

        if(isNull(user)) // 회원가입이 되어있지 않은 경우, 회원 정보 저장
            user = userService.createUser(accessToken, refreshToken, profile);
        else if("A02".equals(user.getCode().getCode())) // 탈퇴회원인 경우, code만 변경
            user = userService.reconnectUser(user);

        // accessToken과 refreshToken 저장
        userService.saveToken(user, accessToken, refreshToken);

        return ResponseEntity.ok(UserProfileResponse.of(kakaoId, profileUrl, nickname));
    }

    @GetMapping("/logout")
    @ApiOperation(value = "카카오 로그아웃", notes = "사용자의 token을 만료 시킨 후, 로그아웃한다.")
    public ResponseEntity<String> logout(@RequestHeader(value = "authorization") String accessToken) {
        kakaoService.logout(accessToken);
        return ResponseEntity.ok("로그아웃 되었습니다.");
    }

    @GetMapping("/disconnect")
    @ApiOperation(value = "카카오 회원 탈퇴", notes = "사용자의 token을 만료 시키고 회원상태 값을 'A02'(탈퇴 회원)로 변경한다.")
    public ResponseEntity<String> disconnect(@RequestHeader(value = "authorization") String accessToken) {
        Long kakaoId = kakaoService.disconnect(accessToken);
        User user = userService.getUserByKakaoId(kakaoId);
        userService.disconnectUser(user);
        userService.deleteToken(user);

        return ResponseEntity.ok("회원탈퇴 되었습니다.");
    }
}