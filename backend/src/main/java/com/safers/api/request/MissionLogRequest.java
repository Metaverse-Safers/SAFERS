package com.safers.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MissionLogRequest {

    String userId;
    String missionId;
    String code;
}
