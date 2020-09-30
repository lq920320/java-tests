package com.asyncdemo.service.impl;

import com.asyncdemo.service.TestService;
import org.springframework.stereotype.Component;

/**
 * @author liuqian
 * @date 2019/4/23  18:36
 */
@Component
public class TestServiceImpl implements TestService {
    @Override
    public String hello() {
        return "Hello";
    }
}
