package other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    public void stream2Test() {
        Integer[] array = {12, 33, 33, 34, 34};
        List<Integer> list = Arrays.stream(array).sorted((a, b) -> b - a).collect(Collectors.toList());
        System.out.println(list);
    }
}
