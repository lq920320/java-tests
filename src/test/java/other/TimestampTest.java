package other;

import org.junit.Test;

import java.sql.Timestamp;

/**
 * @author liuqian
 * @date 2019/6/19  10:34
 */
public class TimestampTest {

    @Test
    public void timestampTest() {
        String date1 = "2019-06-19 10:34:50";
        System.out.println(Timestamp.valueOf(date1).getTime());
    }

    @Test
    public void doubleIntegerTest() {
        String s = "5.00";
        Double a = Double.valueOf(s);
        Integer b = 3;
        Double c = a - b;
        Integer d = a.intValue() - b;
        System.out.println(a);
        System.out.println(a.intValue());
        System.out.println(b);
        System.out.println(c);
        System.out.println(c.intValue());
        System.out.println(d);
    }
}
