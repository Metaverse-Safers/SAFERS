package com.safers.api.service;

import com.safers.common.util.RandomIdUtil;
import com.safers.db.entity.user.Token;
import com.safers.db.entity.user.User;
import com.safers.db.repository.UserRepository;
import com.safers.db.repository.UserTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserTokenRepository userTokenRepository;

    public User createUser(String accessToken, String refreshToken, HashMap<String, Object> profile){
        Long kakaoId = (Long) profile.get("kakaoId");
        String nickname = (String) profile.get("nickname");
        String profileUrl = (String) profile.get("profileUrl");

        User user = new User();
        user.setId(RandomIdUtil.makeRandomId(13));
        user.setKakaoId(kakaoId);
        user.setNickName(nickname);
        user.setProfileUrl(profileUrl);
        user.setCode("A01");
        User newUser = userRepository.save(user);

        return newUser;
    }

    public User getUserByKakaoId(Long kakaoId) {
        Optional<User> user = userRepository.findByKakaoId(kakaoId);
        if(user.isPresent())
            return user.get();
        return null;
    }

    public User disconnectUser(User user) {
        user.setCode("A02"); // 탈퇴회원으로 변경
        userRepository.save(user);
        return user;
    }

    public User reconnectUser(User user) {
        user.setCode("A01"); // 다시 OO회원으로 변경
        userRepository.save(user);
        return user;
    }

    public Token saveToken(User user, String accessToken, String refreshToken){
        Token token = new Token();
        token.setId(RandomIdUtil.makeRandomId(13));
        token.setUserId(user);
        token.setAccessToken(accessToken);
        token.setRefreshToken(refreshToken);
        userTokenRepository.save(token);

        return token;
    }
}
