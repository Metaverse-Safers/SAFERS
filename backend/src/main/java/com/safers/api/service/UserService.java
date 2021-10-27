package com.safers.api.service;

import com.safers.db.entity.User;
import com.safers.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(String accessToken, String refreshToken, HashMap<String, Object> profile){

        Long kakaoId = (Long) profile.get("kakaoId");
        String nickname = (String) profile.get("nickname");
        String profileUrl = (String) profile.get("profileUrl");

        User user = new User();
        user.setId("임시 13자리 글자");
        user.setKakaoId(kakaoId);
        user.setNickName(nickname);
        user.setProfileUrl(profileUrl);

        User newUser = userRepository.save(user);

        return newUser;
    }

    public User getUserByKakaoId(Long kakaoId) {
        Optional<User> user = userRepository.findByKakaoId(kakaoId);

        if(user.isPresent())
            return user.get();

        return null;
    }
}
