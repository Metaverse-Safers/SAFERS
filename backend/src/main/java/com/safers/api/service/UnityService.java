package com.safers.api.service;

import com.safers.api.response.AnimalsLogResponse;
import com.safers.api.response.MapLogResponse;
import com.safers.api.response.MissionLogResponse;
import com.safers.db.entity.code.Code;
import com.safers.db.entity.unity.Animals;
import com.safers.db.entity.unity.Map;
import com.safers.db.entity.unity.Mission;
import com.safers.db.entity.unityLog.AnimalsLog;
import com.safers.db.entity.unityLog.MapLog;
import com.safers.db.entity.unityLog.MissionLog;
import com.safers.db.entity.user.User;
import com.safers.db.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class UnityService {

    @Autowired
    MissionRepository missionRepository;

    @Autowired
    MissionLogRepository missionLogRepository;

    @Autowired
    CodeRepository codeRepository;

    @Autowired
    AnimalsRepository animalsRepository;

    @Autowired
    AnimalsLogRepository animalsLogRepository;

    @Autowired
    MapRepository mapRepository;

    @Autowired
    MapLogRepository mapLogRepository;

    /**
     * 회원 가입 시, 회원별 미션로그 생성
     * @param user
     * @return List<MissionLog>
     */

    public List<MissionLog> createMissionLog(User user){
        List<MissionLog> missionLogList = new ArrayList<>();
        List<Mission> missionList = missionRepository.findAll();

        Code disabled = codeRepository.getById("C01"); // 비활성화 코드
        Code beforeStart = codeRepository.getById("C02");   // 미션 시작 전 & 활성화 코드
        for (Mission mission : missionList) {
            MissionLog missionLog = new MissionLog();
            missionLog.setUser(user);
            missionLog.setMission(mission);
            
            if(mission.getId().equals("S1000"))             // 첫번째 미션일 경우 C02로 상태코드 지정 (초기화)
                missionLog.setCode(beforeStart);
            else
                missionLog.setCode(disabled);

            missionLogRepository.save(missionLog);
            missionLogList.add(missionLog);
        }
        return missionLogList;
    }

    /**
     * 회원 가입 시, 회원별 기본 맵 해금 로그 생성
     * @param user
     */
    public void createMapLog(User user) {
        MapLog mapLog = new MapLog();

        // 초기 맵인 숲/초원 정보 가지고 오기
        Map map = mapRepository.getById("M001");
        mapLog.setMap(map);
        mapLog.setUser(user);
        mapLog.setRegDt(LocalDateTime.now());
        mapLogRepository.save(mapLog);
    }
    
    /**
     * 회원의 미션로그 불러오기
     * @param user
     * @return List<MissionLog>
     */
    public List<MissionLogResponse> getMissionLogByUser(User user){

        List<MissionLog> missionLogList = missionLogRepository.findAllByUser(user).get();
        List<MissionLogResponse> missionLogResponseList = new ArrayList<>();

        if(isNull(missionLogList))
            missionLogList = new ArrayList<MissionLog>();

        for (MissionLog missionLog : missionLogList){
            missionLogResponseList.add(MissionLogResponse.of(missionLog));
        }

        return missionLogResponseList;
    }

    /**
     * 회원의 미션로그 모두 삭제하기 -> 회원 탈퇴 시
     * @param user
     */
    @Transactional
    public void deleteMissionLog(User user){
        missionLogRepository.deleteAllByUser(user);
    }

    /**
     * 회원의 동물로그 모두 삭제하기 -> 회원 탈퇴 시
     * @param user
     */
    @Transactional
    public void deleteAnimalLog(User user) { animalsLogRepository.deleteAllByUser(user); }

    /**
     * 회원의 맵 로그 모두 삭제하기 -> 회원 탈퇴 시
     * @param user
     */
    @Transactional
    public void deleteMapLog(User user) { mapLogRepository.deleteAllByUser(user); }

    /**
     * 회원의 미션로그 수정 -> 미션 활성화->시작가능 / 시작가능->진행중 / 진행중->미션 종료
     * @param user, Mission, String
     * @return boolean
     */
    @Transactional
    public MissionLog updateMissionLog(User user, Mission mission, String code){
        MissionLog missionLog = missionLogRepository.findByUserAndMission(user ,mission).orElseGet(null);

        if(isNull(missionLog))
            return null;

        // code : C01(비활성화), C02(시작전), C03(진행중), C04(진행완료)
        missionLog.setCode(codeRepository.findById(code).get());
        missionLog.setRegDt(LocalDateTime.now());
        missionLogRepository.save(missionLog);
        return missionLog;
    }

    /**
     * mission id로 미션 정보 조회
     * @param id
     * @return Mission
     */
    public Mission getMissionById(String id){
        return missionRepository.findById(id).orElseGet(null);
    }

    /**
     * 회원 동물 로그 불러오기
     * @param user
     * @return List<AnimalsLogResponse>
     */
    public List<AnimalsLogResponse> getAnimalsLogByUser(User user) {
        Optional<List<AnimalsLog>> animalsLogs = animalsLogRepository.findAllByUser(user);
        if(animalsLogs.isPresent()) {
            List<AnimalsLogResponse> animalsLogResponseList = new ArrayList<>();
            for(AnimalsLog animalsLog : animalsLogs.get()) {
                animalsLogResponseList.add(AnimalsLogResponse.of(animalsLog));
            }
            return animalsLogResponseList;
        }

        return null;
    }

    /**
     * 회원 지도 로그 불러오기
     * @param user
     * @return List<MapLogResponse>
     */
    public List<MapLogResponse> getMapLogByUser(User user) {
        Optional<List<MapLog>> mapLogs = mapLogRepository.findAllByUser(user);
        if(mapLogs.isPresent()) {
            List<MapLogResponse> mapLogResponseList = new ArrayList<>();
            for(MapLog mapLog : mapLogs.get()) {
                mapLogResponseList.add(MapLogResponse.of(mapLog));
            }
            return mapLogResponseList;
        }
        return null;
    }

    /**
     * 요청한 회원, 미션 정보를 토대로
     * 1. 미션 로그 수정
     * 2. 동물 로그 추가
     * 3. 맵 로그 추가
     * 4. 다음 미션 코드 변경
     * @param user
     * @param mission
     */
    public void completeMission(User user, Mission mission) {
        // 1. 미션 로그 수정
        MissionLog missionLog = updateMissionLog(user, mission, "C04");
        String[] nextMissions = mission.getNextMission().split("/");
        for(String id : nextMissions) {
            System.out.println(id);
            Mission nextMission = missionRepository.getById(id);
            updateMissionLog(user, nextMission, "C02");
        }

        // 2. 동물 로그 추가
        // 3. 맵 로그 추가
        String[] results = mission.getResultId().split("/");

        if(results[0].charAt(0) == 'M') {        // 맵 해금과 같이 있는 경우
            Map map = mapRepository.getById(results[0]);
            addMapLog(user, map);

            Animals animals = animalsRepository.getById(results[1]);
            addAnimalLog(user, animals);
        } else {                                // 동물 해금 2개일 경우
            for(String result : results) {
                Animals animals = animalsRepository.getById(result);
                addAnimalLog(user, animals);
            }
        }
    }

    /**
     * 맵 로그 저장하기
     * @param user
     * @param map
     */
    public void addMapLog(User user, Map map) {
        MapLog mapLog = new MapLog();
        mapLog.setMap(map);
        mapLog.setUser(user);
        mapLog.setRegDt(LocalDateTime.now());
        mapLogRepository.save(mapLog);
    }

    /**
     * 동물 로그 저장하기
     * @param user
     * @param animals
     */
    public void addAnimalLog(User user, Animals animals) {
        AnimalsLog animalsLog = new AnimalsLog();
        animalsLog.setAnimals(animals);
        animalsLog.setUser(user);
        animalsLog.setRegDt(LocalDateTime.now());
        animalsLogRepository.save(animalsLog);
    }


    /**
     * 미션 로그에 저장된 미션 등록 시간 반환
     * @param user
     * @param mission
     * @return LocalDateTime
     */
    public LocalDateTime getRegDateByUserAndMission(User user, Mission mission) {
        return missionLogRepository.findByUserAndMission(user, mission).orElseGet(null).getRegDt();
    }
}
