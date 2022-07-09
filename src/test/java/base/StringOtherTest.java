package base;

import org.junit.Test;

import java.util.Arrays;
import java.util.Formatter;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * StringBuffer、StringBuilder、StringTokenizer相关的测试
 *
 * @author zetu
 * @date 2022/7/8
 */
public class StringOtherTest {

    @Test
    public void stringBufferTest() {

    }

    public static void main(String[] args) {
        String str = "study";
        str.concat("tonight");
        System.out.println(str); // 输出: study
        StringBuffer strB = new StringBuffer("study");
        strB.append("tonight");
        System.out.println(strB); // 输出: studytonight
    }


    @Test
    public void formatterTest() {
        // 这与上面 StringBuilder 例子做了同样的事情
        int one = 1;
        String color = "red";
        Formatter f = new Formatter();
        System.out.print(f.format("One=%d, colour=%s%n", one, color));
        // 打印 "One=1, Colour=red" 然后跟了一个换行符
        // 使用 String.format 便捷方法也是一样
        System.out.print(String.format("One=%d, color=%s%n", one, color));
    }

    @Test
    public void stringJoinerTest() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (String s : new String[]{"A", "B", "C"}) {
            sj.add(s);
        }
        System.out.println(sj); // Prints "[A, B, C]"
    }

    @Test
    public void repeatStringTest() {
        final int n = 10;
        final String s = "abc";
        String result = "";
        for (int i = 0; i < n; i++) {
            result += s;
        }
    }

    @Test
    public void repeatStringTest2() {
        final int n = 10;
        final String s = "abc";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(s);
        }
        String result = builder.toString();
    }

    @Test
    public void stringTokenizerTest() {
        StringTokenizer st = new StringTokenizer("apple ball cat dog", " ");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }

    @Test
    public void stringTokenizerTest2() {
        StringTokenizer st = new StringTokenizer("apple,ball cat,dog", ",");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }

    @Test
    public void stringSplitTest() {
        String str = "this is a test string.";
        String[] parts = str.split("(?<=\\G.{8})");
        System.out.println(Arrays.toString(parts));
    }



}
