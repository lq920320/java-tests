package other;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author zetu
 * @date 2021/4/21
 */
public class MapBeanTest {

    @Test
    public void fastJsonMapBeanTest() {
        User user = new User();
        user.setName("校长");
        user.setAge(3);
        user.setSalary(new BigDecimal("123456789.0123"));
        /*对象转map*/
        String jsonString1 = JSON.toJSONString(user);
        Map map = JSON.parseObject(jsonString1, Map.class);
        System.out.println("map = " + map);// map = {name=校长, salary=123456789.0123, age=3}

        String jsonString = JSON.toJSONString(map);
        User user1 = JSON.parseObject(jsonString, User.class);//json转对象
        System.out.println("user1 = " + user1); //user1 = User{name='校长', age=3, salary=123456789.0123}
    }

    @Data
    private static class User {
        private String name;
        private Integer age;
        private BigDecimal salary;
    }
}
