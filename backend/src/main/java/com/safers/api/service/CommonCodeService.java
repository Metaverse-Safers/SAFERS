package com.safers.api.service;

import com.safers.db.entity.code.CommonCode;
import com.safers.db.repository.CommonCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonCodeService {

    @Autowired
    CommonCodeRepository commonCodeRepository;

    /**
     * 원하는 공통 코드의 코드 목록을 가져온다.
     * @return List<CommonCode>
     */
    public List<CommonCode> findCommonCode(String commonCode){
        return commonCodeRepository.findByCommonCode(commonCode).get();
    }
}
