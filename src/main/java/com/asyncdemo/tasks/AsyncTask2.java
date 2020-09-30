package com.asyncdemo.tasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @author liuqian
 * @date 2019/4/10  17:35
 */
@Component
@Slf4j
public class AsyncTask2 {
    private static Random random = new Random();

    @Async("taskExecutor")
    public Future<String> run() throws Exception {
        long sleep = random.nextInt(1000);
        log.info("开始任务，需耗时：" + sleep + "毫秒");
        Thread.sleep(sleep);
        log.info("任务完成");
        return new AsyncResult<>("test");
    }
}
