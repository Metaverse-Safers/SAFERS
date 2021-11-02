package com.safers.api.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Nullable;

@Getter
@Setter
@Builder
public class UserProfileRequest {

    String id;
    String nickName;
    MultipartFile profileFile; // 프로필 이미지 파일에 사용되는 변수

}
