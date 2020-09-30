package other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liuqian
 * @date 2019/6/17  16:43
 */
public class ListSetTest {

    @Test
    public void listSetTest() {
        List<Long> oldList = new ArrayList<Long>() {{
            add(1L);
            add(2L);
            add(3L);
            add(4L);
            add(5L);
        }};
        List<Long> newList = new ArrayList<Long>() {{
            add(3L);
            add(4L);
            add(5L);
            add(6L);
            add(7L);
        }};

        Set<Long> oldSet = new HashSet<>(oldList);
        Set<Long> newSet = new HashSet<>(newList);

        Set<Long> result = new HashSet<>();
        result.clear();
        result.addAll(oldSet);
        result.removeAll(newSet);
        System.out.println("oldSet 与 newSet 的差集，要删除的数据：" + result);

        result.clear();
        result.addAll(newSet);
        result.removeAll(oldSet);
        System.out.println("newSet 与 newSet 的差集，要插入的数据：" + result);
    }
}
