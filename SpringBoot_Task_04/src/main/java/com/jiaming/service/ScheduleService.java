package com.jiaming.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author jmstart
 * @create 2020-05-27 13:11
 *
 * 定时任务
 */
@Service
public class ScheduleService {
    // 秒 分 时 日 月 周几
    //"0 * * * * MON-FRI" = 周一到周五 每月 每天 每时 每分 每0秒 执行下列任务
    //"0,1,2 * * * * MON-FRI" = 周一到周五 每月 每天 每时 每分 每 0,1,2秒 执行下列任务
    //@Scheduled(cron = "0 * * * * MON-FRI") //定时任务
    //@Scheduled(cron = "0,1,2 * * * * MON-FRI")
    //@Scheduled(cron = "0-3 * * * * MON-FRI") //周一到周五 每月 每天 每时 每分 每 0,1,2,3秒 执行下列任务
    @Scheduled(cron = "0/3 * * * * MON-FRI") //每三秒执行一次
    public void task02() {
        System.out.println("定时执行任务...");
    }

}


