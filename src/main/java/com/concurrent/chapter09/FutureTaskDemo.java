package com.concurrent.chapter09;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 使用FutureTask实现泡茶过程
 *
 * @author zetu
 * @date 2021/8/8
 */
@Slf4j
public class FutureTaskDemo {

    public static final int SLEEP_GAP = 500;

    public static String getCurThreadName() {
        return Thread.currentThread().getName();
    }

    static class HotWaterJob implements Callable<Boolean> {

        @Override
        public Boolean call() throws Exception {
            try {
                log.info("洗好水壶");
                log.info("灌上凉水");
                log.info("放在火上");
                // 睡眠一段时间，代表烧水中
                Thread.sleep(SLEEP_GAP);
                log.info("水开了");
            } catch (InterruptedException e) {
                log.info(" 发生异常被中断。", e);
                return false;
            }
            log.info(" 运行结束。");
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
                log.info(" 清洗工作发生异常被中断");
                return false;
            }

            log.info(" 清洗工作 运行结束");
            return true;
        }
    }

    public static void drinkTea(boolean waterOk, boolean cupOk) {
        if (waterOk && cupOk) {
            log.info("泡茶喝");
        } else if (!waterOk) {
            log.info("烧水失败，没有茶喝了");
        } else if (!cupOk) {
            log.info("杯子没洗好，没有茶喝了");
        }
    }

    public static void main(String[] args) {
        Thread.currentThread().setName("主线程");

        Callable<Boolean> hJob = new HotWaterJob();
        FutureTask<Boolean> hTask = new FutureTask<>(hJob);
        Thread hThread = new Thread(hTask, "** 烧水-Thread");

        Callable<Boolean> wJob = new WashJob();
        FutureTask<Boolean> wTask = new FutureTask<>(wJob);
        Thread wThread = new Thread(wTask, "$$ 清洗-Thread");

        hThread.start();
        wThread.start();

        // ...在等待烧水和清洗时可以干点其他事

        try {
            boolean waterOk = wTask.get();
            boolean cupOk = wTask.get();

            drinkTea(waterOk, cupOk);
        } catch (InterruptedException e) {
            log.error(getCurThreadName() + "发生异常被中断", e);
        } catch (ExecutionException e) {
            log.error("执行异常", e);
        }
        log.info(getCurThreadName() + " 运行结束");
    }

}
