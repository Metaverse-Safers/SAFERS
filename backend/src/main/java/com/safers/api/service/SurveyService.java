package com.safers.api.service;

import com.safers.api.response.SurveyResultResponse;
import com.safers.api.response.SurveySimpleResponse;
import com.safers.db.entity.Survey;
import com.safers.db.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {
    @Autowired
    SurveyRepository surveyRepository;

    /**
     * 성격유형 검사 결과에 따른 조회
     * @param mbti
     * @return SurveyResultResponse
     */
    public SurveyResultResponse findMbtiData(String mbti){
        Survey survey = surveyRepository.findById(mbti).get();

        List<String> explanation = new ArrayList<String>();
        for (String singleExplanation: survey.getExplanation().split("/"))
            explanation.add(singleExplanation);

        List<String> extinction = new ArrayList<String>();
        for (String singleExtinction: survey.getExtinction().split("/"))
            extinction.add(singleExtinction);

        List<String> personality = new ArrayList<String>();
        for (String singlePersonality: survey.getPersonality().split("/"))
            personality.add(singlePersonality);

        List<SurveySimpleResponse> buddy = new ArrayList<SurveySimpleResponse>();
        for (String singleBuddy: survey.getBuddy().split("/"))
            buddy.add(findMbtiSimpleData(singleBuddy));

        List<SurveySimpleResponse> enemy = new ArrayList<SurveySimpleResponse>();
        for (String singleEnemy: survey.getEnemy().split("/"))
            enemy.add(findMbtiSimpleData(singleEnemy));

        return SurveyResultResponse.builder()
                .mbti(survey.getMbti())
                .area(survey.getArea())
                .name(survey.getName())
                .imageUrl(survey.getImageUrl())
                .introduce(survey.getIntroduce())
                .explanation(explanation)
                .extinction(extinction)
                .personality(personality)
                .buddy(buddy)
                .enemy(enemy).build();
    }

    public SurveySimpleResponse findMbtiSimpleData(String mbti){
        Survey survey = surveyRepository.findById(mbti).get();
        SurveySimpleResponse response = new SurveySimpleResponse();
        response.setMbti(survey.getMbti());
        response.setImageUrl(survey.getImageUrl());
        return response;
    }
}
