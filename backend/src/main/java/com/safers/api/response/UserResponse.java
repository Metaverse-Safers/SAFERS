package com.safers.api.response;

import com.safers.db.entity.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponse{

    String id;
    String nickName;
    String profileUrl;

    public static UserResponse of(User user){
        return UserResponse.builder()
                .id(user.getId())
                .nickName(user.getNickName())
                .profileUrl(user.getProfileUrl())
                .build();
    }

    public static UserResponse of(String id, String nickName, String profileUrl){
        return UserResponse.builder()
                .id(id)
                .nickName(nickName)
                .profileUrl(profileUrl)
                .build();
    }
}
