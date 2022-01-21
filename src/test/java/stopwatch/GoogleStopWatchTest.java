package stopwatch;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * google 中的StopWatch类
 * 总结下来，功能太少，不好用
 *
 * @author zetu
 * @date 2022/1/21
 */
public class GoogleStopWatchTest {

    @Test
    public void stopWatchTest() throws InterruptedException {
        Stopwatch sw = Stopwatch.createUnstarted();

        sw.start();
        TimeUnit.SECONDS.sleep(2);
        sw.stop();

        System.out.println(sw.toString());
        System.out.println(sw.elapsed());
        System.out.println(sw.elapsed(TimeUnit.SECONDS));
    }
}
