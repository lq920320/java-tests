package com.asyncdemo.service.impl;

import com.asyncdemo.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author liuqian
 * @date 2019/4/23  18:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceImplTest {

    @Autowired
    private TestService testService;

    @Test
    public void hello() {
        System.out.println(testService.hello());
    }
}