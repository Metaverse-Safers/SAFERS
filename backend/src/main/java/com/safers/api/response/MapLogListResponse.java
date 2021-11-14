package com.safers.api.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MapLogListResponse {

    List<MapLogResponse> mapLogResponseList;

    public static MapLogListResponse of(List<MapLogResponse> mapLogResponseList){
        MapLogListResponse response = new MapLogListResponse();
        response.setMapLogResponseList(mapLogResponseList);
        return response;
    }
}
