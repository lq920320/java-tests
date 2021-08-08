package other;

import cn.hutool.core.util.RandomUtil;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Locale;

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

    @Test
    public void upperCaseTest() {
        String a = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(a.toUpperCase(Locale.ROOT));
    }

    @Test
    public void randomStr() {
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomUtil.randomString("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789", 10));
        }
    }
}
