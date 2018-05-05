package com.tfa.service;

import org.springframework.stereotype.Service;

@Service
public class KeywordsService {

    public boolean isLimitValid(String slimit) {
        int limit = Integer.valueOf(slimit);
        return (limit > 0) && (limit <= 500);
    }

}