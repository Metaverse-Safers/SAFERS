package com.safers.api.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {

    Integer statusCode;
    String statusMessage;

    public static BaseResponse of(Integer statusCode, String statusMessage) {
        BaseResponse body = new BaseResponse();
        body.statusMessage = statusMessage;
        body.statusCode = statusCode;
        return body;
    }
}
