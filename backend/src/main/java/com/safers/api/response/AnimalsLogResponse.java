package com.safers.api.response;

import com.safers.db.entity.unityLog.AnimalsLog;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class AnimalsLogResponse {

    String animalsId;

    public static AnimalsLogResponse of(AnimalsLog animalsLog) {
        return AnimalsLogResponse.builder()
                .animalsId(animalsLog.getAnimals().getId())
                .build();
    }
}
