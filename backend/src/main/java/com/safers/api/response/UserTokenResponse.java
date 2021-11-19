package com.safers.api.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserTokenResponse {

    String accessToken;
    String refreshToken;

    public static UserTokenResponse of(String accessToken, String refreshToken){
        return UserTokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
