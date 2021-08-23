package other;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2019/6/14  10:33
 */
public class DivideTest {

    @Test
    public void numberTest() {
        String a = "5.0";
        System.out.println(Float.valueOf(a));

        String b = "001";
        System.out.println(Long.valueOf(b));
    }

    @Test
    public void divideTest() {
        int a = 5;
        int b = 3;
        System.out.println(5 / 3);
        System.out.println(Float.parseFloat(Integer.toString(a)));
        System.out.println(Float.parseFloat(Integer.toString(b)));
        System.out.println((int) Math.ceil(Float.parseFloat(Integer.toString(a)) / Float.parseFloat(Integer.toString(b))));
    }

    @Test
    public void divideGetDay() {
        Long a = 1296000L;
        System.out.println(a / 3600 / 24);
        Long b = 259200L;
        System.out.println(b / 3600 / 24);

        System.out.println(4 * 3600 * 24);
    }
}
