package com.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @author liuqian
 * @date 2019/7/2  14:53
 */
public class ThreadLocalExample implements Runnable {

    /**
     * SimpleDateFormat 不是线程安全的，所以每个线程都要有自己独立的副本
     */
    private static final ThreadLocal<SimpleDateFormat> FORMATTER = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample obj = new ThreadLocalExample();
        int threadCount = 10;
        for (int i = 0; i < threadCount; i++) {
            Thread t = new Thread(obj, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread Name= " + Thread.currentThread().getName() + " default Formatter = " + FORMATTER.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        FORMATTER.set(new SimpleDateFormat());
        System.out.println("Thread Name= " + Thread.currentThread().getName() + " formatter = " + FORMATTER.get().toPattern());
    }
}
