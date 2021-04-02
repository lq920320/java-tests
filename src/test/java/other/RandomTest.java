package other;

import org.junit.Test;

import java.util.Random;
import java.util.UUID;

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


    @Test
    public void loopRandom() {
        StringBuilder sb = new StringBuilder();
        Random ran = new Random();
        for (int i = 0; i < 10; i++) {
            sb.append(ran.nextInt(9) + 1);
        }
        System.out.println(sb.toString());
        System.out.println(sb.length());


        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb2.append(new Random().nextInt(9) + 1);
        }
        System.out.println(sb2.toString());
        System.out.println(sb2.length());
    }

    @Test
    public void uuidTest() {
        UUID id = UUID.randomUUID();
        System.out.println(id.toString());
    }

    @Test
    public void snowflakeTest() {
        long id = SnowflakeUtils.genId();
        String idStr = Long.toString(id);

        System.out.println(id);
        System.out.println(idStr.length());
        System.out.println(idStr.substring(idStr.length() - 8));
    }

    @Test
    public void randomSeedTest() {
        String randomDigitalStr;
        Random random = new Random(System.nanoTime());

        for (int i = 0; i < 10; i++) {
            randomDigitalStr = String.valueOf(random.nextLong());
            System.out.println(randomDigitalStr.replaceAll("-", ""));
            System.out.println(randomDigitalStr.length());
        }
    }

}
