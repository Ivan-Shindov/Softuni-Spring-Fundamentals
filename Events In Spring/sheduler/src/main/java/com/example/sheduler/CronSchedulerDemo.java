package com.example.sheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CronSchedulerDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(CronSchedulerDemo.class);

    @Scheduled(cron = "${scheduler.cron}")
    public void showTimeWithCron() {
        LOGGER.info("Time from cron: {}", LocalDateTime.now());
    }

}
