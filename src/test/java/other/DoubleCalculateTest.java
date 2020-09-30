package other;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2019/7/19  10:22
 */
public class DoubleCalculateTest {

    @Test
    public void doubleCalculateTest() {
        Double a = 5.00;
        Integer b = 2;
        Integer c = -1;
        double d = a + b;
        double e = a + c;
        System.out.println(d);
        System.out.println(e);
    }
}
