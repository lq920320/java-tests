package base;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * String的一些测试用例
 *
 * @author zetu
 * @date 2022/7/6
 */
public class StringTest {


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the String");
//        String s = scanner.next();
//        char[] a = s.toCharArray();
//        System.out.println("Enter the character you are looking for");
//        System.out.println(s);
//        String c = scanner.next();
//        char d = c.charAt(0);
//        for (int i = 0; i <= s.length(); i++) {
//            if (a[i] == d) {
//                if (d >= 'a' && d <= 'z') {
//                    d -= 32;
//                } else if (d >= 'A' && d <= 'Z') {
//                    d += 32;
//                }
//                a[i] = d;
//                break;
//            }
//        }
//        s = String.valueOf(a);
//        System.out.println(s);
//    }

    public static void main(String[] args) {
        String a = "alpha";
        String b = "alpha";
        String c = new String("alpha");
        // 三个字符串都是相等的
        System.out.println(a.equals(b) && b.equals(c));
        // 只有 a 和 b 指向相同的堆对象
        System.out.println(a == b);
        System.out.println(a != c);
        System.out.println(b != c);
    }

    @Test
    public void stringIndexTest() {
        String s = "this is a long sentence";
        int i = s.indexOf('i'); // 字符串中第一个 'i' 在索引 2 的位置
        int j = s.indexOf("long"); // s 中第一次出现 "long" 的索引为 10
        int k = s.indexOf('z'); // k 是 -1 因为 'z' 并没有在字符串 s 中出现
        int h = s.indexOf("LoNg"); // h 是 -1 因为 "LoNg" 也没有在字符串 s 中找到
    }

    @Test
    public void stringSplitTest() {
        String s = "a|b|c";
        String regex = Pattern.quote("|");
        String[] arr = s.split(regex);
        System.out.println(Arrays.toString(arr));

        String[] arr1 = s.split("\\|");
        System.out.println(Arrays.toString(arr1));
    }

    @Test
    public void stringSplitTest2() {
//        String str = "the lazy fox jumped over the brown fence";
//        StringTokenizer tokenizer = new StringTokenizer(str);
//        while (tokenizer.hasMoreTokens()) {
//            System.out.println(tokenizer.nextToken());
//        }

        String str = "jumped over";
        // 字符 `u` 和 `e` 都会被当作分隔符
        StringTokenizer tokenizer = new StringTokenizer(str, "ue");
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
    }

    @Test
    public void stringJoinTest() {
        String[] elements = {"foo", "bar", "foobar"};
        String singleString = String.join(" + ", elements);
        System.out.println(singleString); // 输出 "foo + bar + foobar"

        StringJoiner sj = new StringJoiner(", ", "[", "]");
        // 最后两个参数是可选的，它们定义了结果字符串的前缀和后缀
        sj.add("foo");
        sj.add("bar");
        sj.add("foobar");
        System.out.println(sj); // 打印 "[foo, bar, foobar]"

//        Stream<String> stringStream = Stream.of("foo", "bar", "foobar");
//        String joined = stringStream.collect(Collectors.joining(", "));
//        System.out.println(joined); // 打印 "foo, bar, foobar"

        Stream<String> stringStream = Stream.of("foo", "bar", "foobar");
        String joined = stringStream.collect(Collectors.joining(", ", "{", "}"));
        System.out.println(joined); // 打印 "{foo, bar, foobar}"
    }

    @Test
    public void subStringTest() {
        String s = "this is an example";
        String a = s.substring(11); // a 将从字符串的字符 11 的位置保留到末尾("example")
        String b = s.substring(5, 10); // b 将从字符串的字符 5 的位置保留到字符 10 的位置("is an")
        String c = s.substring(5, s.length() - 3); // c 将从字符串的字符 5 的位置保留到字符串到末尾字符3的位置("is an exam")

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        String datestring = "2015年11月17日";
        datestring = datestring.substring(0, 4) + "-" +
                datestring.substring(5, 7) + "-" +
                datestring.substring(8, 10);
// 结果为 2015-11-17
        System.out.println(datestring);
    }

    @Test
    public void lineSeparatorShow() {
        System.out.println(JSON.toJSONString(System.getProperty("line.separator")));
        System.out.println(JSON.toJSONString(System.lineSeparator()));
    }

    @Test
    public void reverseStringTest() {
        String code = "code";
        System.out.println(code);
        StringBuilder sb = new StringBuilder(code);
        code = sb.reverse().toString();
        System.out.println(code);
    }

    @Test
    public void reverseStringTest2() {
        String code = "code";
        System.out.println(code);
        char[] array = code.toCharArray();
        for (int index = 0, mirroredIndex = array.length - 1; index < mirroredIndex; index++, mirroredIndex--) {
            char temp = array[index];
            array[index] = array[mirroredIndex];
            array[mirroredIndex] = temp;
        }
        // 打印 edoc
        System.out.println(new String(array));
    }

    public class Person {
        String name;
        int age;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "My name is " + this.name + " and my age is " + this.age;
        }
    }

    @Test
    public void toStringTest() {
        Person person = new Person(20, "John");
        System.out.println(person.toString());
    }

    @Test
    public void replaceTest() {
//        String s = "spiral metal petal et al.";
//        System.out.println(s.replaceAll("(\\w*etal)","$1lica"));

        String s = "spiral metal petal et al.";
        System.out.println(s.replaceFirst("(\\w*etal)", "$1lica"));
    }

    @Test
    public void lengthTest() {
        String str = "Hello, World!";

        System.out.println(str.length());

        int length = str.codePointCount(0, str.length());

        System.out.println(length);

        long length2 = str.codePoints().count();

        System.out.println(length2);
    }

    @Test
    public void countTest() {
        String text = "One fish, two fish, red fish, blue fish";
        // 统计一个子字符串出现的次数
        String stringTarget = "fish";
        int stringOccurrences = StringUtils.countMatches(text, stringTarget); // 4
        // 统计一个字符出现的次数
        char charTarget = ',';
        int charOccurrences = StringUtils.countMatches(text, charTarget); // 3

        System.out.println(stringOccurrences);
        System.out.println(charOccurrences);
    }


    @Test
    public void countTest2() {
        String text = "One fish, two fish, red fish, blue fish";
        System.out.println(countStringInString("fish", text)); // prints 4
        System.out.println(countStringInString(",", text)); // prints 3
    }

    public static int countStringInString(String search, String text) {
        Pattern pattern = Pattern.compile(search);
        Matcher matcher = pattern.matcher(text);
        int stringOccurrences = 0;
        while (matcher.find()) {
            stringOccurrences++;
        }
        return stringOccurrences;
    }


}
