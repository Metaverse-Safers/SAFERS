package com.safers.api.response;

import com.safers.db.entity.unity.Mission;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MissionResponse {

    String id;
    String title;
    String nextMission;
    String resultId;
    String animalName;

    public static MissionResponse of(Mission mission) {
        return MissionResponse.builder()
                .id(mission.getId())
                .title(mission.getTitle())
                .nextMission(mission.getNextMission())
                .resultId(mission.getResultId())
                .animalName(mission.getAnimalName())
                .build();
    }
}
