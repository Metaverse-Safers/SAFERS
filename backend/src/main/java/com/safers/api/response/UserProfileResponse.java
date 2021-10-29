package com.safers.api.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserProfileResponse {

    Long kakaoId;
    String profileUrl;
    String nickname;

    public static UserProfileResponse of(Long kakaoId, String profileUrl, String nickname){
        return UserProfileResponse.builder()
                .kakaoId(kakaoId)
                .profileUrl(profileUrl)
                .nickname(nickname).build();
    }
}
