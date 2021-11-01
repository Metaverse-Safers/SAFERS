package com.safers.api.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserPresentResponse {

    Long kakaoId;
    boolean isPresent; // 해당 회원이 존재하면 True, 존재하지 않으면 False

    public static UserPresentResponse of(Long kakaoId, boolean isPresent){
        return UserPresentResponse.builder()
                .kakaoId(kakaoId)
                .isPresent(isPresent)
                .build();
    }
}
