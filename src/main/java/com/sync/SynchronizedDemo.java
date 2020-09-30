package com.sync;

/**
 * @author liuqian
 * @date 2019/7/2  10:52
 */
public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("synchronized code");
        }
    }
}
