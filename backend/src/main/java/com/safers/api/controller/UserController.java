package com.safers.api.controller;

import com.safers.api.response.UserProfileResponse;
import com.safers.api.response.UserTokenResponse;
import com.safers.api.service.KakaoService;
import com.safers.api.service.UserService;
import com.safers.db.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    KakaoService kakaoService;

    @PostMapping("/token")
    public ResponseEntity<UserTokenResponse> requestAuthCode(@RequestBody HashMap<String, Object> map) {
        String code = (String) map.get("code");

        // code값을 이용한 accessToken 조회
        HashMap<String, String> token = kakaoService.getTokens(code);
        String accessToken = token.get("accessToken");
        String refreshToken = token.get("refreshToken");

        return ResponseEntity.ok(UserTokenResponse.of(accessToken, refreshToken));
    }

    @PostMapping("/login")
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
        else if("A02".equals(user.getCode())) // 탈퇴회원인 경우, code만 변경
            user = userService.reconnectUser(user);

        // accessToken과 refreshToken 저장
        userService.saveToken(user, accessToken, refreshToken);

        return ResponseEntity.ok(UserProfileResponse.of(kakaoId, profileUrl, nickname));
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader String authorization) {
        // Request Header의 Authorization에 AccessToken을 담아서 보낸다.
        kakaoService.logout(authorization);
        return ResponseEntity.ok("로그아웃 되었습니다.");
    }

    @GetMapping("/disconnect")
    public ResponseEntity<String> disconnect(@RequestHeader String authorization) {
        Long kakaoId = kakaoService.disconnect(authorization);
        User user = userService.getUserByKakaoId(kakaoId);
        userService.disconnectUser(user);

        return ResponseEntity.ok("회원탈퇴 되었습니다.");
    }
}