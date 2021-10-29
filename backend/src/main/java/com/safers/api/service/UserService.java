package com.safers.api.service;

import com.safers.common.util.RandomIdUtil;
import com.safers.db.entity.user.Token;
import com.safers.db.entity.user.User;
import com.safers.db.repository.CodeRepository;
import com.safers.db.repository.UserRepository;
import com.safers.db.repository.UserTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserTokenRepository userTokenRepository;

    @Autowired
    CodeRepository codeRepository;

    public User createUser(String accessToken, String refreshToken, HashMap<String, Object> profile){
        Long kakaoId = (Long) profile.get("kakaoId");
        String nickname = (String) profile.get("nickname");
        String profileUrl = (String) profile.get("profileUrl");

        User user = new User();
        user.setId(RandomIdUtil.makeRandomId(13));
        user.setKakaoId(kakaoId);
        user.setNickName(nickname);
        user.setProfileUrl(profileUrl);
        user.setCode(codeRepository.findById("A01").get());
        User newUser = userRepository.save(user);

        return newUser;
    }

    public User getUserByKakaoId(Long kakaoId) {
        Optional<User> user = userRepository.findByKakaoId(kakaoId);
        if(user.isPresent())
            return user.get();
        return null;
    }

    public User updateUser(HashMap<String, Object> profile){
        String id = (String) profile.get("id");
        String nickname = (String) profile.get("nickname");
        String profileUrl = (String) profile.get("profileUrl");

        User user = userRepository.findById(id).orElse(null);
        user.setNickName(nickname);
        user.setProfileUrl(profileUrl);

        return user;
    }

    public User disconnectUser(User user) {
        user.setCode(codeRepository.findById("A02").get()); // 탈퇴회원으로 변경
        userRepository.save(user);
        return user;
    }

    public User reconnectUser(User user) {
        user.setCode(codeRepository.findById("A01").get()); // 다시 일반회원으로 변경
        userRepository.save(user);
        return user;
    }

    public Token saveToken(User user, String accessToken, String refreshToken){
        // 해당 회원에 대한 Token값이 남아 있는지 체크
        Token token = userTokenRepository.findByUserId(user).orElse(null);

        if(isNull(token)) {
            token = new Token();
            token.setUserId(user);
        }

        token.setAccessToken(accessToken);
        token.setRefreshToken(refreshToken);
        userTokenRepository.save(token);

        return token;
    }

    public void deleteToken(User user){
        Token token = userTokenRepository.findByUserId(user).orElse(null);

        if(!isNull(token))
            userTokenRepository.delete(token);
    }

    /**
     * id로 User 정보 반환
     * @param id
     * @return User
     */
    public Optional<User> getUserById(String id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent())
            return user;
        return null;
    }
}
