package com.safers.api.controller;

import com.safers.api.request.AnimalsLogRequest;
import com.safers.api.request.MissionRequest;
import com.safers.api.response.*;
import com.safers.api.service.BoardService;
import com.safers.api.service.CodeService;
import com.safers.api.service.UnityService;
import com.safers.api.service.UserService;
import com.safers.db.entity.code.Code;
import com.safers.db.entity.unity.Animals;
import com.safers.db.entity.unity.Map;
import com.safers.db.entity.unity.Mission;
import com.safers.db.entity.unityLog.MissionLog;
import com.safers.db.entity.user.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Unity 관련 API 요청처리를 위한 컨트롤러
 */
@Api(value = "유니티 API", tags = "Unity")
@RestController
@RequestMapping("/api/unity")
public class UnityController {

    @Autowired
    UnityService unityService;

    @Autowired
    UserService userService;

    @Autowired
    BoardService boardService;

    @Autowired
    CodeService codeService;

    @GetMapping("/mission")
    @ApiOperation(value = "회원의 미션 정보 조회", notes = "회원 Id로 회원의 현재 미션 수행 정보를 가져온다.")
    public ResponseEntity<MissionLogListResponse> requestMissionLog(@RequestParam(value = "id") String id) {

        User user = userService.getUserById(id);
        List<MissionLogResponse> missionLogList = unityService.getMissionLogByUser(user);

        return ResponseEntity.ok(MissionLogListResponse.of(missionLogList));
    }

    @ApiOperation(value = "회원 동물 해금 현황", notes = "해당 회원의 동물 해금 내역을 가져온다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "동물 로그 조회 성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 에러 발생")
    })
    @GetMapping("/animal")
    public ResponseEntity<AnimalsLogListResponse> requestAnimalsLog(@RequestParam(value = "userId") String userId) {
        User user = userService.getUserById(userId);
        List<AnimalsLogResponse> animalsLogResponseList = unityService.getAnimalsLogByUser(user);

        return ResponseEntity.ok(AnimalsLogListResponse.of(animalsLogResponseList));
    }

    @ApiOperation(value = "맵별 회원 동물 해금 현황", notes = "주어진 맵 내에서 해당 회원의 동물 해금 내역을 가져온다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "동물 & 맵 로그 조회 성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 에러 발생")
    })
    @PostMapping("/animal")
    public ResponseEntity<AnimalsLogListResponse> requestAnimalsLogInMap(@RequestBody AnimalsLogRequest animalsLogRequest) {
        User user = userService.getUserById(animalsLogRequest.getUserId());
        Map map = unityService.getMapById(animalsLogRequest.getMapId());
        List<Animals> animals = unityService.getAnimalsListByMap(map);
        List<AnimalsLogResponse> animalsLogResponseList = unityService.getAnimalsLogByAnimalsName(user, animals);

        return ResponseEntity.ok(AnimalsLogListResponse.of(animalsLogResponseList));
    }

    @ApiOperation(value = "회원 맵 해금 현황", notes = "해당 회원의 맵 해금 내역을 가져온다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "맵 로그 조회 성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 에러 발생")
    })
    @GetMapping("/map")
    public ResponseEntity<MapLogListResponse> requestMapLog(@RequestParam(value = "userId") String userId){
        User user = userService.getUserById(userId);
        List<MapLogResponse> mapLogResponseList = unityService.getMapLogByUser(user);

        return ResponseEntity.ok(MapLogListResponse.of(mapLogResponseList));
    }

    
    @PostMapping("/complete")
    @ApiResponses({
            @ApiResponse(code = 200, message = "미션 완료 처리 성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 에러 발생")
    })
    @ApiOperation(value = "회원의 미션 완료 처리", notes = "해당 미션을 완료 상태로 변경한다.")
    public ResponseEntity<MissionResponse> completeMission(@RequestBody MissionRequest missionRequest) {

        User user = userService.getUserById(missionRequest.getUserId());
        Mission mission = unityService.getMissionById(missionRequest.getMissionId());

        unityService.completeMission(user, mission);

        return ResponseEntity.ok(MissionResponse.of(mission));
    }

    @PostMapping("/isupload")
    @ApiResponses({
            @ApiResponse(code = 200, message = "업로드 미션 관련 게시글 반환"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 에러 발생")
    })
    @ApiOperation(value = "업로드 미션 관련 게시글 반환", notes = "업로드 미션을 받은 후 작성된 삭제되지 않은 상태인 게시글 리스트를 모두 반환한다.")
    public ResponseEntity<BoardUnityListResponse> isUploadBoard(@RequestBody MissionRequest missionRequest) {

        User user = userService.getUserById(missionRequest.getUserId());
        Mission mission = unityService.getMissionById(missionRequest.getMissionId());
        Code code = codeService.getCodeById(missionRequest.getCode());
        LocalDateTime regDate = unityService.getRegDateByUserAndMission(user, mission);
        List<BoardUnityResponse> boardUnityResponses = boardService.findBoardByUserAndRegDateAndCode(user, regDate, code);

        return ResponseEntity.ok(BoardUnityListResponse.of(boardUnityResponses));
    }

    @PostMapping("/change")
    @ApiResponses({
            @ApiResponse(code = 200, message = "미션 로그 상태 변경 성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 에러 발생")
    })
    @ApiOperation(value = "미션 수행 상태 변경", notes = "유저 아이디와 미션 아이디, 코드값을 받은 후 해당 유저의 미션 로그 내 미션 아이디와 일치하는 값을 코드 값으로 변경한다.")
    public ResponseEntity<MissionResponse> changeMissionLog(@RequestBody MissionRequest missionRequest) {
        User user = userService.getUserById((missionRequest.getUserId()));
        Mission mission = unityService.getMissionById(missionRequest.getMissionId());

        MissionLog missionLog = unityService.updateMissionLog(user, mission, missionRequest.getCode());
        return ResponseEntity.ok(MissionResponse.of(unityService.getMissionById(missionLog.getMission().getId())));
    }
}
