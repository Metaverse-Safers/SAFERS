package com.safers.api.service;

import com.safers.api.response.MissionLogResponse;
import com.safers.db.entity.code.Code;
import com.safers.db.entity.unity.Mission;
import com.safers.db.entity.unityLog.MissionLog;
import com.safers.db.entity.user.User;
import com.safers.db.repository.CodeRepository;
import com.safers.db.repository.MissionLogRepository;
import com.safers.db.repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class UnityService {

    @Autowired
    MissionRepository missionRepository;

    @Autowired
    MissionLogRepository missionLogRepository;

    @Autowired
    CodeRepository codeRepository;

    /**
     * 회원 가입 시, 회원별 미션로그 생성
     * @param User
     * @return List<MissionLog>
     */

    public List<MissionLog> createMissionLog(User user){
        List<MissionLog> missionLogList = new ArrayList<>();
        List<Mission> missionList = missionRepository.findAll();

        Code disabled = codeRepository.getById("C01"); // 비활성화 코드
        for (Mission misson : missionList) {
            MissionLog missionLog = new MissionLog();
            missionLog.setUser(user);
            missionLog.setMission(misson);
            missionLog.setCode(disabled);

            missionLogRepository.save(missionLog);
            missionLogList.add(missionLog);
        }
        return missionLogList;
    }

    /**
     * 회원의 미션로그 불러오기
     * @param User
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
     * @param User
     * @return boolean
     */
    @Transactional
    public void deleteMissionLog(User user){
        missionLogRepository.deleteAllByUser(user);
    }

    /**
     * 회원의 미션로그 수정 -> 미션 활성화->시작가능 / 시작가능->진행중 / 진행중->미션 종료
     * @param User, Mission, String
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
     * @param String
     * @return Mission
     */
    public Mission getMissionById(String id){
        return missionRepository.findById(id).orElseGet(null);
    }
}
