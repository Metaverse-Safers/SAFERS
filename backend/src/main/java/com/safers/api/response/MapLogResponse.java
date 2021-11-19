package com.safers.api.response;

import com.safers.db.entity.unityLog.MapLog;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class MapLogResponse {

    String mapId;

    public static MapLogResponse of(MapLog mapLog) {
        return MapLogResponse.builder()
                .mapId(mapLog.getMap().getId())
                .build();
    }
}
