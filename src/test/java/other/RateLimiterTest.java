package other;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

/**
 * @author liuqian
 * @date 2019/4/12  14:51
 */
public class RateLimiterTest {

    @Test
    public void rateLimiterTest() {
        RateLimiter limiter = RateLimiter.create(1.0);
        for (int i = 1; i < 10; i = i + 2) {
            double waitTime = limiter.acquire(i);
            System.out.println("cutTime = " + System.currentTimeMillis() + " acq:" + i + "  " + waitTime);
        }
    }
}
