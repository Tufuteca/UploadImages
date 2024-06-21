package com.tufuteca.uploadImage.service;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class TimeAgoService {

    public String getTimeAgo(LocalDateTime dateTime) {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(dateTime, now);

        long seconds = duration.getSeconds();
        long minutes = duration.toMinutes();
        long hours = duration.toHours();
        long days = duration.toDays();

        if (seconds < 60) {
            return seconds + " секунд назад";
        } else if (minutes < 60) {
            return minutes + " минут назад";
        } else if (hours < 24) {
            return hours + " часов назад";
        } else {
            return days + " дней назад";
        }
    }
}