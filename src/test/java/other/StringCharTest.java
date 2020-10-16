package other;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2020/10/16 16:23
 */
public class StringCharTest {

    @Test
    public void stringChar() {
        String a = new String(new char[5]);
        System.out.println(a);
        System.out.println(a.replace('\0', '0'));
    }
}
