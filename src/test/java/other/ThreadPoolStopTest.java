package other;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * 线程池中某些线程阻塞或者未执行
 *
 * @author zetu
 * @date 2021/6/4
 */
public class ThreadPoolStopTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        AtomicInteger i = new AtomicInteger(0);
        for (int j = 0; j < 20; j++) {
            final int threadNum = j;
//            executorService.submit(() -> {
//                try {
//                    singleThreadPool(threadNum);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            })
            singleThreadPool(threadNum);
        }

        executorService.shutdown();

//        Thread.sleep(60000);
    }

    private static void singleThreadPool(int i) throws InterruptedException {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("saveTraceLog-saveAddTrace2-%d").build();
        ExecutorService single = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue(),
                threadFactory);

        single.submit(() -> System.out.println("这里是线程:" + i));
        single.shutdown();
    }
}
