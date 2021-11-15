package com.safers.api.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MapLogListResponse {

    List<MapLogResponse> mapLogList;

    public static MapLogListResponse of(List<MapLogResponse> mapLogResponseList){
        MapLogListResponse response = new MapLogListResponse();
        response.setMapLogList(mapLogResponseList);
        return response;
    }
}
