package com.effectjava.item42;

import cn.hutool.core.thread.ThreadUtil;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * TODO description
 *
 * @author zetu
 * @date 2021/5/26
 */
@Slf4j
public class Demo2 {

    public static void main(String[] args) {
        LoadingCache<Integer, AtomicLong> loadingCache;

        loadingCache = CacheBuilder.newBuilder()
                .expireAfterWrite(3, TimeUnit.SECONDS)
                // 这里可以监听移除动作
                .removalListener(notification -> log.info("删除原因={}，删除 key={},删除 value={}",
                        notification.getCause(), notification.getKey(), notification.getValue()))
                .build(new CacheLoader<Integer, AtomicLong>() {
                    @Override
                    public AtomicLong load(Integer key) throws Exception {
                        // 当 key 值对应当 value 不存在时，返回当默认值
                        return new AtomicLong(0);
                    }
                });

        loadingCache.put(1, new AtomicLong(1000));
        try {
            // 放入当值 1000
            System.out.println(loadingCache.get(1));
            // 默认值 0，而且会放入到 cache 中
            System.out.println(loadingCache.get(2));

            ThreadUtil.sleep(4000);
            // 过期，返回 默认值 0
            System.out.println(loadingCache.get(1));
        } catch (ExecutionException e) {
            log.error("failed", e);
        }
    }
}
