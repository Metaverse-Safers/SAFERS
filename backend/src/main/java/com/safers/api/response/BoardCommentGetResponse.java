package com.safers.api.response;

import com.safers.db.entity.board.BoardComment;
import com.safers.db.entity.user.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardCommentGetResponse {

    @ApiModelProperty
    String id;

    @ApiModelProperty
    String comment;

    @ApiModelProperty
    Boolean isDelete;

    @ApiModelProperty
    String nickName;

    @ApiModelProperty
    LocalDateTime regDt;

    @ApiModelProperty
    String userId;

    @ApiModelProperty
    String boardId;

    public static BoardCommentGetResponse of(BoardComment boardComment, User user) {
        BoardCommentGetResponse res = new BoardCommentGetResponse();
        res.setId(boardComment.getId());
        res.setComment(boardComment.getComment());
        res.setIsDelete(boardComment.getIsDelete());
        res.setNickName(user.getNickName());
        res.setRegDt(boardComment.getRegDt());
        res.setUserId(user.getId());
        res.setBoardId(boardComment.getBoard().getId());

        return res;
    }
}
