package com.example.daina.service;

import com.example.daina.entity.SentryBox;
import com.example.daina.mapper.SentryBoxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Daina
 * @description:
 * @date: Created in 10:35 2019/4/1
 */
@Service
public class SentryBoxService {
    @Autowired
    SentryBoxMapper sentryBoxMapper;

    public List<SentryBox> getSentry(String parkingLotId) {
        List<SentryBox> sentryBoxes = sentryBoxMapper.getSentry(parkingLotId);
        return sentryBoxes;
    }
}
