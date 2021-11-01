package com.safers.api.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserPresentResponse {

    boolean isPresent; // 해당 회원이 존재하면 True, 존재하지 않으면 False

    public static UserPresentResponse of(boolean isPresent){
        return UserPresentResponse.builder()
                .isPresent(isPresent)
                .build();
    }
}
