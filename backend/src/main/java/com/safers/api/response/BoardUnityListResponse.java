package com.safers.api.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BoardUnityListResponse {

    List<BoardUnityResponse> boardList;

    public static BoardUnityListResponse of(List<BoardUnityResponse> boardUnityListResponseList) {
        BoardUnityListResponse listResponse = new BoardUnityListResponse();
        listResponse.setBoardList(boardUnityListResponseList);
        return listResponse;
    }
}
