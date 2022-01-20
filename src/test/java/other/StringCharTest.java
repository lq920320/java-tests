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

        for (String s : aArray) {
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


    @Test
    public void fullTextTest() {
        // 处理富文本数据
        String a = "<p><img src=\\\"https://images.sursung.com/test/dis/F1120FDFB54D4E3FB192998404D2CF89_s12474_h300_w371.jpg\\\"/>abdaskhdaj撒打算打算的阿萨里打开撒娇</p>";

        a = a.replaceAll("</?[^>]+>", "");
        System.out.println(a);
        a = a.replaceAll("<a>\\s*|\t|\r|\n|&nbsp;|</a>", "");

        System.out.println(a);
    }
}
