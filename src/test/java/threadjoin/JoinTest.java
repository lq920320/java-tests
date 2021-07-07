package threadjoin;

import org.junit.Test;
import other.ThreadJoinTest;

/**
 * TODO description
 *
 * @author zetu
 * @date 2021/6/25
 */
public class JoinTest {

    @Test
    public void joinTest() {

        OddThread oddThread = new OddThread();
        EvenThread evenThread = new EvenThread();

        oddThread.run();
        evenThread.run();
    }

    static public class OddThread implements Runnable {
        @Override
        public void run() {
            System.out.println("我想先执行");
        }
    }

    static public class EvenThread implements Runnable {
        @Override
        public void run() {
            System.out.println("我想先执行");
        }
    }
}
