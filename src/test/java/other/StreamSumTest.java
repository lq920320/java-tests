package other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuqian
 * @date 2019/7/9  11:31
 */
public class StreamSumTest {

    @Test
    public void streamSumTest() {
        List<Integer> intList = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
        }};

        Integer sum = intList.parallelStream().reduce(Integer::sum).orElse(0);
        System.out.println(sum);
    }
}
