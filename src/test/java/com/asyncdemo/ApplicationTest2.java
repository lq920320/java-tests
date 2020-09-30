package com.asyncdemo;

import com.asyncdemo.tasks.ThreadPoolTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author liuqian
 * @date 2019/4/8  18:44
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTest2 {
    @Autowired
    private ThreadPoolTask threadPoolTask;

    @Test
    public void threadPoolTaskTest() throws Exception {
        threadPoolTask.doTaskOne();
        threadPoolTask.doTaskTwo();
        threadPoolTask.doTaskThree();

        Thread.currentThread().join();
    }
}
