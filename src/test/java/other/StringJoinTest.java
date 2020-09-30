package other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author liuqian
 * @date 2019/4/9  11:23
 */
public class StringJoinTest {

    @Test
    public void arrayOutOfBound() {
        List<String> stringList1 = new ArrayList<String>() {{
            add("1");
            add("2,4");
            add("3");
            add("4");
            add("5");
            add("6");
            add("7");
        }};
        List<String> stringList2 = new ArrayList<String>() {{
            add("1");
            add("2");
            add("3");
            add("4");
        }};

        stringList1.addAll(stringList2);

        stringList1.forEach(System.out::println);
        System.out.println(stringList1.toString());
        String resultStr = String.join("; ", stringList1);
        String emptyArrayStr = String.join("| ", new ArrayList<>());

        System.out.println(resultStr);
        System.out.println(emptyArrayStr);

    }


    @Test
    public void emptyMapGet() {
        System.out.println(new HashMap<>().get("123"));
    }
}
