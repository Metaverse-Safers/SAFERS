package com.safers.api.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AnimalsLogListResponse {

    List<AnimalsLogResponse> animalsLogResponseList;

    public static AnimalsLogListResponse of(List<AnimalsLogResponse> animalsLogResponseList){
        AnimalsLogListResponse response = new AnimalsLogListResponse();
        response.setAnimalsLogResponseList(animalsLogResponseList);
        return response;
    }
}
