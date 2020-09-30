package other;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2019/4/4  14:59
 */
public class DeadLockDemoTest {

    private static final String resource_a = "A";
    private static final String resource_b = "B";

    @Test
    public void deadLockTest() {
        deadLock();
    }

    private static void deadLock() {
        Thread threadA = new Thread(() -> {
            synchronized (resource_a) {
                System.out.println("get resource a");
                try {
                    Thread.sleep(8000);
                    synchronized (resource_b) {
                        System.out.println("get resource b");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadB = new Thread(() -> {
            synchronized (resource_b) {
                System.out.println("get resource b");
                synchronized (resource_a) {
                    System.out.println("get resource a");
                }
            }
        });
        threadA.start();
        threadB.start();
    }

}
