package com.concurrent.chapter09;

import lombok.extern.slf4j.Slf4j;

/**
 * join()实现泡茶喝是一个异步阻塞版本
 *
 * @author zetu
 * @date 2021/7/9
 */
@Slf4j
public class JoinDemo {

    /**
     * 程序中有三个线程：主线程main、烧水线程hThread和清洗线程wThread。
     * main调用了hThread.join()实例方法，合并烧水线程，也调用了wThread.join()实例方法，合并清洗线程。
     */

    private static final int SLEEP_GAP = 500;

    public static String getCurThreadName() {
        return Thread.currentThread().getName();
    }

    static class HotWaterThread extends Thread {
        public HotWaterThread() {
            super("** 烧水-Thread");
        }

        @Override
        public void run() {
            try {
                log.info("洗好水壶");
                log.info("灌上凉水");
                log.info("放在火上");
                Thread.sleep(SLEEP_GAP);
                log.info("水开了");
            } catch (InterruptedException e) {
                log.info(" 发生异常被中断");
            }
            log.info("运行结束");
        }
    }

    static class WashThread extends Thread {
        public WashThread() {
            super("$$ 清洗-Thread");
        }

        @Override
        public void run() {
            try {
                log.info("洗茶壶");
                log.info("洗茶杯");
                log.info("拿茶叶");
                // 清洗中
                Thread.sleep(SLEEP_GAP);
                log.info("洗完了");
            } catch (InterruptedException e) {
                log.info(" 发生异常被中断");
            }
            log.info("运行结束");
        }
    }

    public static void main(String[] args) {
        Thread hThread = new HotWaterThread();
        Thread wThread = new WashThread();
        // 烧水
        hThread.start();
        // 清洗
        wThread.start();

        try {
            // 合并烧水
            hThread.join();
            // 合并清洗
            wThread.join();
            Thread.currentThread().setName("主线程");

            log.info("泡茶喝");
        } catch (InterruptedException e) {
            log.info(getCurThreadName() + "发生异常被中断。");
        }
        log.info(getCurThreadName() + "运行结束。");
    }


}
