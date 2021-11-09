package com.safers.api.response;

import com.safers.db.entity.unityLog.MissionLog;
import com.safers.db.entity.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
public class MissionLogResponse {

    String missionId;

    String code;

    String userId;

    LocalDateTime regDate;

    public static MissionLogResponse of(MissionLog missionLog){
        return MissionLogResponse.builder()
                .missionId(missionLog.getMission().getId())
                .code(missionLog.getCode().getCode())
                .userId(missionLog.getUser().getId())
                .regDate(missionLog.getRegDt())
                .build();
    }
}
