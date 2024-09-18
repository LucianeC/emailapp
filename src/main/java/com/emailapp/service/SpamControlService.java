package com.emailapp.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SpamControlService {

    private Map<String, List<LocalDateTime>> emailSentTimes = new HashMap<>();

    public boolean isSpam(String userId) {
        List<LocalDateTime> sentTimes = emailSentTimes.getOrDefault(userId, new ArrayList<>());
        LocalDateTime now = LocalDateTime.now();

        sentTimes.removeIf(time -> time.isBefore(now.minusMinutes(1)));
        if (sentTimes.size() >= 5) {
            return true;
        }

        sentTimes.add(now);
        emailSentTimes.put(userId, sentTimes);
        return false;
    }
}
