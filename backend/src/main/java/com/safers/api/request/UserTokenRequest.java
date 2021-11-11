package com.safers.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTokenRequest {

    String accessToken;
    String refreshToken;

}
