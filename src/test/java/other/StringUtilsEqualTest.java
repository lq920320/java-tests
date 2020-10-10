package other;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author liuqian
 * @date 2020/10/10 15:13
 */
public class StringUtilsEqualTest {

    @Test
    public void stringUtilsEqualTest() {
        String a = null;
        String b = "This is a String";
        String c = "This is a String";
        // StringUtils.equals(CharSequence cs1, CharSequence cs2) 两个参数皆为 nullable
        System.out.println(StringUtils.equals(a, c));
        System.out.println(StringUtils.equals(b, c));
    }
}
