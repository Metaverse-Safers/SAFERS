package com.safers.api.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {

    Integer statusCode;
    String statusMessage;

}
