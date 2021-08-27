package concurrency;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * guava future callback 测试
 *
 * @author zetu
 * @date 2021/8/5
 */
public class FutureCallbackTest {

    @Test
    public void futureCallbackTest() throws InterruptedException {
        // 创建一个线程缓冲池Service
        ExecutorService executor = Executors.newCachedThreadPool();
        // 创建一个ListeningExecutorService实例
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(executor);
        // 提交一个可监听的线程
        ListenableFuture<String> futureTask = executorService.submit
                (new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return "Task completed";
                    }
                });
        MyFutureCallbackImpl callback = new MyFutureCallbackImpl();
        // 线程结果处理回调函数
        Futures.addCallback(futureTask, callback, executorService);
        Thread.sleep(1000);
        // 处理后的线程执行结果："Task completed successfully "
        assertThat(callback.getCallbackResult(), is("Task completed successfully"));
    }

    @Test
    public void listenableFutureTest() throws InterruptedException {
        // 创建一个线程缓冲池Service
        ExecutorService executor = Executors.newCachedThreadPool();
        // 创建一个ListeningExecutorService实例
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(executor);
        // 提交一个可监听的线程
        ListenableFuture<String> futureTask = executorService.submit
                (new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        System.out.println("Task completed");
                        return "Task completed";
                    }
                });
        futureTask.addListener(new Runnable() {
            @Override
            public void run() {
                System.out.println("task ended");
            }
        }, executorService);
    }
}
