package com.safers.api.controller;

import com.safers.api.response.UserTokenResponse;
import com.safers.api.service.KakaoService;
import com.safers.api.service.UserService;
import com.safers.db.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    KakaoService kakaoService;

    public ResponseEntity<UserTokenResponse> requestAuthCode(@RequestParam("code") String code){
        HashMap<String, String> token = kakaoService.getTokens(code);
        String accessToken = token.get("accessToken");
        String refreshToken = token.get("resfreshToken");

        return ResponseEntity.ok(UserTokenResponse.of(200, "Success", accessToken, refreshToken));
    }
}
