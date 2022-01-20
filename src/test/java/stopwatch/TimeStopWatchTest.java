package stopwatch;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * lang3.time 里的stopWatch
 * 相比于 springframework 以及 Hutool 工具类里的 StopWatch，time 中的功能更少一些，但更单纯，
 * 只是作为秒表使用，只有开始和结束，不能设置任务的ID，也不能得到任务执行最后统计结果，
 * 其中有split() 方法可以实现分别得到时间，类似跑步的排名
 *
 * @author zetu
 * @date 2022/1/20
 */
public class TimeStopWatchTest {

    @Test
    public void stopWatchTest() throws InterruptedException {
        StopWatch sw = new StopWatch();

        sw.start();
        SECONDS.sleep(2);
        sw.stop();
        System.out.println(sw.getNanoTime());
        System.out.println(sw.getTime(SECONDS));

        sw.reset();
        sw.start();
        SECONDS.sleep(8);
        sw.stop();
        System.out.println(sw.getNanoTime());
        System.out.println(sw.getTime());

        sw.reset();
        sw.start();
        SECONDS.sleep(16);
        sw.stop();
        System.out.println(sw.getNanoTime());
        System.out.println(sw.getTime());
    }

    @Test
    public void stopWatchSplitTest() throws InterruptedException {
        StopWatch sw = new StopWatch();

        sw.start();
        SECONDS.sleep(2);
        sw.split();
        System.out.println(sw.getNanoTime());
        System.out.println(sw.getTime(SECONDS));

        SECONDS.sleep(8);
        sw.split();
        System.out.println(sw.getNanoTime());
        System.out.println(sw.getTime());

        SECONDS.sleep(1);
        sw.split();
        sw.stop();
        System.out.println(sw.getNanoTime());
        System.out.println(sw.getTime());
    }

    @Test
    public void stopWatchTest2() throws InterruptedException {
        org.apache.commons.lang.time.StopWatch sw = new org.apache.commons.lang.time.StopWatch();

        sw.start();
        SECONDS.sleep(2);
        sw.stop();
        System.out.println(sw.getTime());

        sw.reset();
        sw.start();
        SECONDS.sleep(8);
        sw.stop();
        System.out.println(sw.getTime());

        sw.reset();
        sw.start();
        SECONDS.sleep(16);
        sw.stop();
        System.out.println(sw.getTime());
    }

}
