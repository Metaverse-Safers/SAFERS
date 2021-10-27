package com.safers.api.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserTokenResponse extends BaseResponse{

    String accessToken;
    String refreshToken;

    public static UserTokenResponse of(Integer statusCode, String statusMessage, String accessToken, String refreshToken){
        return UserTokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
