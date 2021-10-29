package com.safers.api.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
public class UserRequest {

    String id;
    String nickName;
    MultipartFile profileUrl;

}
