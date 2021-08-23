package other;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;
import org.junit.Test;

/**
 * @author liuqian
 * @date 2019/7/11  10:40
 */
public class JsonTest {

    @Test
    public void jsonTest() {
        Employee employee = new Employee() {{
            setEmpNO("001");
            setName("Tom");
            setAge(26);
        }};
        if ("123".equals(employee.getEmail())) {
            System.out.println("asdahsda");
        } else {
            System.out.println("It works");
        }
    }

    @Test
    public void jsonArrayTest() {
        JSONArray array = JSONArray.parseArray("[]");
        System.out.println(array);
    }

    @Test
    public void jsonObjectTest() {
        Employee employee = new Employee();
        employee.setEmpNO("1");
        JSONObject a = JSONObject.parseObject(JSON.toJSONString(employee, SerializerFeature.WriteMapNullValue));
        System.out.println(a);
    }

    @Data
    private class Employee {
        private String empNO;
        private String name;
        private Integer age;
        private String email;
    }
}
