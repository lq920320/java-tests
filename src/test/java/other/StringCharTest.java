package other;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;

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

    @Test
    public void stringReplaceTest() {
        String a = "这是第一行数据，分割符\n" +
                "     这是第二行数据，分割符\n" +
                "这是，分割符\n" +
                "   空格   ，分割符\n";
        String[] aArray = a.split("，分割符");

        for (int i = 0; i < aArray.length; i++) {
            String s = aArray[i];
            System.out.println(s);
            String sTrim = s.replace("\n", "");
            if (StringUtils.isBlank(sTrim)) {
                continue;
            }
            System.out.println(sTrim);
        }
    }

    @Test
    public void stringReplaceTest2() {
        String a = "这是第一行数据，分割符\n" +
                "     这是第二行数据，分割符\n" +
                "这是，分割符\n" +
                "   空格   ，分割符\n";
        String[] aArray = a.split("\\n");
        for (String s : aArray) {
            System.out.println(s);
        }
    }
}
