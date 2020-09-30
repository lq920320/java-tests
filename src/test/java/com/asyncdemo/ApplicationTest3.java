package com.asyncdemo;

import com.asyncdemo.tasks.AsyncTask2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author liuqian
 * @date 2019/4/10  17:42
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTest3 {

    @Autowired
    private AsyncTask2 task;

    @Test
    public void test() throws Exception {
        Future<String> futureResult = task.run();
        String result = futureResult.get(5, TimeUnit.SECONDS);
        log.info(result);
    }
}
