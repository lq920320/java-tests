package com.asyncdemo;

import com.asyncdemo.tasks.AsyncTask;
import com.asyncdemo.tasks.SyncTask;
import com.asyncdemo.tasks.ThreadPoolTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

/**
 * @author liuqian
 * @date 2019/4/8  18:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private AsyncTask asyncTask;
    @Autowired
    private SyncTask syncTask;
    @Autowired
    private ThreadPoolTask threadPoolTask;

    @Test
    public void asyncTaskTest() throws Exception {
        long start = System.currentTimeMillis();

        Future<String> task1 = asyncTask.doTaskOne();
        Future<String> task2 = asyncTask.doTaskTwo();
        Future<String> task3 = asyncTask.doTaskThree();

        // 三个任务都调用完成，退出循环等待
        while (!task1.isDone() || !task2.isDone() || !task3.isDone()) {
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

    @Test
    public void syncTaskTest() throws Exception {
        long start = System.currentTimeMillis();
        syncTask.doTaskOne();
        syncTask.doTaskTwo();
        syncTask.doTaskThree();
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

    @Test
    public void threadPoolTaskTest() throws Exception {
        threadPoolTask.doTaskOne();
        threadPoolTask.doTaskTwo();
        threadPoolTask.doTaskThree();

        Thread.currentThread().join();
    }
}
