package other;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2019/7/1  17:43
 */
public class ThreadJoinTest {

    /**
     * 主线程需要等待子线程执行完成之后再结束，这个时候就要用到 join() 方法了，另外，一个线程需要等待另外一个线程也需要用到 join() 方法
     */

    @Test
    public void threadJoinTest() {
        try {
            MyThread threadTest = new MyThread();
            threadTest.start();
            Thread.sleep(2000);
            threadTest.join();
            System.out.println("我想当threadTest对象执行完毕后我再执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static public class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("我想先执行");
        }
    }
}
