package com.safers.api.response;

import com.safers.db.entity.unityLog.MissionLog;
import com.safers.api.response.MissionLogResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MissionLogListResponse {

    List<MissionLogResponse> missionLogList;

    public static MissionLogListResponse of(List<MissionLogResponse> missionLogList){
        MissionLogListResponse response = new MissionLogListResponse();
        response.setMissionLogList(missionLogList);
        return response;
    }
}
