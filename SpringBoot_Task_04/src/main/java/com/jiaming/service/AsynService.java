package com.jiaming.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author jmstart
 * @create 2020-05-27 13:00
 *
 * 异步任务
 */
@Service
public class AsynService {

    @Async //标识异步方法
    public void task01() throws Exception {
        Thread.sleep(3000);
        System.out.println("task01 处理数据中...");
    }
}
