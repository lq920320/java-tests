package com.concurrent.chapter09;

import com.google.common.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * guava FutureCallback
 *
 * @author zetu
 * @date 2021/8/8
 */
@Slf4j
public class FutureCallbackDemo {

    public static final int SLEEP_GAP = 3000;

    static class HotWaterJob implements Callable<Boolean> {

        @Override
        public Boolean call() throws Exception {
            try {
                log.info("洗好水壶");
                log.info("灌上凉水");
                log.info("烧开水");
                // 线程睡眠一段时间，代表烧水中
                Thread.sleep(SLEEP_GAP);
                log.info("水开了");
            } catch (InterruptedException e) {
                log.error(" 发生异常被中断");
                return false;
            }
            log.info("烧水工作，运行结束");
            return true;
        }
    }

    static class WashJob implements Callable<Boolean> {

        @Override
        public Boolean call() throws Exception {
            try {
                log.info("洗茶壶");
                log.info("洗茶杯");
                log.info("拿茶叶");
                // 线程睡眠一段时间，代表清洗中
                Thread.sleep(SLEEP_GAP);
                log.info("洗完了");
            } catch (InterruptedException e) {
                log.error(" 清洗工作发生异常被中断");
            }
            log.info(" 清洗工作，运行结束");
            return true;
        }
    }

    /**
     * 泡茶喝的工作
     */
    static class DrinkJob {
        boolean waterOk = false;
        boolean cupOk = false;

        // 泡茶喝，回调方法
        public void drinkTea() {
            if (waterOk && cupOk) {
                log.info("泡茶喝，茶喝完");
                this.waterOk = false;
            }
        }
    }

    /**
     * 烧水线程为pool-1-thread-1，清洗线程为pool-1-thread-2，在二者完成之前，泡茶喝线程已经执行完了。泡茶喝的工作在异步回调方法drinkTea()中执行，执行的线程并不是“泡茶喝”线程，而是烧水线程和清洗线程。
     */
    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("泡茶喝线程");
        // 新起一个线程，作为泡茶主线程
        DrinkJob drinkJob = new DrinkJob();

        // 烧水的业务逻辑
        Callable<Boolean> hotJob = new HotWaterJob();
        // 清洗的业务逻辑
        Callable<Boolean> washJob = new WashJob();

        // 创建Java线程池
        ExecutorService jPool = Executors.newFixedThreadPool(10);
        // 包装Java线程池，构造 guava 线程池
        ListeningExecutorService gPool = MoreExecutors.listeningDecorator(jPool);

        // 烧水的回调钩子
        FutureCallback<Boolean> hotWaterHook = new FutureCallback<Boolean>() {
            @Override
            public void onSuccess(@Nullable Boolean r) {
                if (Boolean.TRUE.equals(r)) {
                    drinkJob.waterOk = true;
                    drinkJob.drinkTea();
                }
            }

            @Override
            public void onFailure(@NotNull Throwable t) {
                log.error("烧水失败，没有茶喝了", t);
            }
        };

        // 启动烧水线程
        ListenableFuture<Boolean> hotFuture = gPool.submit(hotJob);
        // 设置烧水任务的回调钩子
        Futures.addCallback(hotFuture, hotWaterHook, gPool);

        // 启动清洗线程
        ListenableFuture<Boolean> washFuture = gPool.submit(washJob);
        // 使用匿名实例，作为清洗之后的回调钩子
        Futures.addCallback(washFuture, new FutureCallback<Boolean>() {
            @Override
            public void onSuccess(@Nullable Boolean r) {
                if (Boolean.TRUE.equals(r)) {
                    drinkJob.cupOk = true;
                    drinkJob.drinkTea();
                }
            }

            @Override
            public void onFailure(@NotNull Throwable t) {
                log.error("杯子洗不了，没有茶喝了", t);
            }
        }, gPool);

        log.info("干点其他事");
        Thread.sleep(1000);
        log.info("执行完成");
    }

}
