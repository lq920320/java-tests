package other;

import org.junit.Test;

import java.util.Random;

/**
 * @author liuqian
 * @date 2019/7/11  18:22
 */
public class RandomTest {

    @Test
    public void randomTest() {

        System.out.println(identity());
        System.out.println(identity());
        System.out.println(identity());
        System.out.println(identity());
        System.out.println(identity().length());
    }

    private String identity() {
        String identityPrefix = "500";
        long timestamp = System.currentTimeMillis();
        Random random = new Random();
        int a = random.nextInt(10);
        int b = random.nextInt(10);
        return identityPrefix + timestamp + a + b;
    }
}
