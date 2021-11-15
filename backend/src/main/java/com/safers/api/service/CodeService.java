package com.safers.api.service;

import com.safers.db.entity.code.Code;
import com.safers.db.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService {
    @Autowired
    CodeRepository codeRepository;

    public Code getCodeByName(String name) {
        return codeRepository.getByName(name).orElse(null);
    }

    public Code getCodeById(String id) {
        return codeRepository.getById(id);
    }

    public Code getCodeByCode(String code) {return codeRepository.findByCode(code).get();}
}
