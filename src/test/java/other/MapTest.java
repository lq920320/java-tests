package other;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zetu
 * @date 2022/1/20
 */
public class MapTest {


    @Test
    public void mapTest() {
        Map<String, Integer> a = new HashMap<>();

        Map<String, Integer> b = new HashMap<>();
        b.put("a", 1);
        b.put("b", 2);
        b.put("c", 3);
        b.put("d", 4);
        a.putAll(b);

        Map<String, Integer> c = new HashMap<>();
        c.put("d", 4);
        c.put("e", 3);
        c.put("c", 43);
        c.put("g", 6);
        a.putAll(c);

        System.out.println(JSON.toJSONString(a));
    }

    @Test
    public void mapRemoveTest() {
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("X", new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }});
        map.put("Y", new ArrayList<Integer>() {{
            add(4);
            add(5);
            add(6);
        }});
        map.put("Z", new ArrayList<Integer>() {{
            add(7);
            add(8);
            add(9);
        }});
        // map.remove(); return the oldValue that removed
        List<Integer> xList = map.remove("X");
        System.out.println("after remove X: " + map);
        System.out.println("removed X: " + xList);

        List<Integer> yList = map.remove("Y");
        System.out.println("after remove Y: " + map);
        System.out.println("removed Y: " + yList);

        List<Integer> zList = map.remove("Z");
        System.out.println("after remove Z: " + map);
        System.out.println("removed Z: " + zList);
    }

}
