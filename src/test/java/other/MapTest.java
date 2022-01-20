package other;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
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

}
