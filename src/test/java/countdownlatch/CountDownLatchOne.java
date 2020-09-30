package countdownlatch;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author liuqian
 * @date 2019/7/2  16:53
 * <p>
 * CountDownLatch 是一个同步工具类，它允许一个或多个线程一直等待，直到其他线程执行完后再执行。
 * 三种典型用法：
 * ① 某一线程在开始运行前等待 n 个线程执行完毕。将 CountDownLatch 的计数器初始化为 n ：new CountDownLatch(n)，每当一个任务线程执行完毕，就将计数器减1 countDownLatch.countDown() ，当计数器为 0 时，在 CountDownLatch 上 await() 的线程就会被唤醒。
 * ② 实现多个线程开始执行任务的最大并行性。注意是并行性，不是并发，强调的是多个线程在某一时刻同时开始执行。类似于赛跑，将多个线程放到起点，等待发令枪响，然后同时开跑。做法是初始化一个共享的 CountDownLatch 对象，将其计数器初始化为 1 ：new CountDownLatch(1)，多个线程在开始执行任务前首先 countDownLatch.await()，当主线程调用 countDown() 时，计数器变为0，多个线程同时被唤醒。
 * ③ 死锁检查：一个非常方便的使用场景是，你可以使用 n 个线程访问共享资源，在每次测试阶段的线程数目是不同的，并尝试产生死锁。
 */
public class CountDownLatchOne {

    private static final int threadCount = 550;

    @Test
    public void countDownLatchTest() throws InterruptedException {
        // 创建一个具有固定线程数量的线程池对象
        ExecutorService threadPool = new ThreadPoolExecutor(300, 300, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        threadPool.shutdown();
        System.out.println("finish");
    }

    public static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Thread number: " + threadNum);
        Thread.sleep(1000);
    }
}
