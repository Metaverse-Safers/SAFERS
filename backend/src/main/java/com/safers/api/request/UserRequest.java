package com.safers.api.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserRequest {

    String id;
    String nickName;
    String profileUrl;

}
