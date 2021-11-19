package com.safers.api.response;

import com.safers.db.entity.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BoardUnityResponse {

    String userId;
    String title;
    String content;

    public static BoardUnityResponse of(Board board) {
        return BoardUnityResponse.builder()
                .userId(board.getUser().getId())
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }
}
