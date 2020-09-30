package other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuqian
 * @date 2019/5/15  17:24
 */
public class ListBuildToHashMap {

    /**
     * 将一个形如["1,2", "2,3", "3,4"]的列表转成Map {1=2, 2=3, 3=4}
     */
    @Test
    public void transformListToMap() {
        List<String> stringList = new ArrayList<String>() {{
            add("1,2");
            add("2,3");
            add("3,4");
        }};
        System.out.println(stringList);
        Map<String, String> map1 = new HashMap<>();
        stringList.forEach(str -> {
            String[] values = str.split(",");
            map1.put(values[0], values[1]);
        });
        System.out.println(map1);
    }
}
