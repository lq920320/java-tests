package stopwatch;

import cn.hutool.core.date.StopWatch;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * hutool 中stopWatch用法
 *
 * @author zetu
 * @date 2022/1/20
 */
public class HutoolStopWatchTest {

    @Test
    public void stopWatchTest() throws InterruptedException {
        StopWatch sw = new StopWatch("出门上班过程");

        sw.start("起床");
        TimeUnit.SECONDS.sleep(2);
        sw.stop();

        sw.start("洗漱");
        TimeUnit.SECONDS.sleep(5);
        sw.stop();

        sw.start("锁门");
        TimeUnit.SECONDS.sleep(1);
        sw.stop();

        System.out.println(sw.shortSummary());
        System.out.println("================================");
        System.out.println(sw.prettyPrint());
        System.out.println(sw.getTotalTimeSeconds());
        System.out.println(sw.getTaskCount());
    }
}
