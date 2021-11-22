package com.example.sheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FixedDelaySchedulerDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(CronSchedulerDemo.class);

    @Scheduled(fixedDelay = 3500, initialDelay = 5000)
    public void showTimeWithCron() {
        LOGGER.info("Time from fixed delay: {}", LocalDateTime.now());
    }

}
