package com.asyncdemo.tools;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuqian
 * @date 2019/4/29  15:02
 */
public final class MultipleThreadCountDownKit {
    /**
     * 计数器
     */
    private AtomicInteger counter;

    /**
     * 通知对象
     */
    private Object notify;
    private Notify notifyListen;

    public MultipleThreadCountDownKit(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("count < 0");
        }
        counter = new AtomicInteger(number);
        notify = new Object();
    }

    /**
     * 线程完成后计数-1
     */
    public void countDown() {
        if (counter.get() <= 0) {
            return;
        }
        int count = this.counter.decrementAndGet();
        if (count < 0) {
            throw new RuntimeException("Concurrent error");
        }
        if (count == 0) {
            synchronized (notify) {
                notify.notify();
            }
        }
    }

    public void await() throws InterruptedException {
        synchronized (notify) {
            while (counter.get() > 0) {
                notify.wait();
            }
            if (notifyListen != null) {
                notifyListen.notifyListen();
            }
        }
    }
}
