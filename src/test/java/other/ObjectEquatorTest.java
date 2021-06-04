package other;

import com.alibaba.fastjson.JSON;
import com.github.dadiyang.equator.Equator;
import com.github.dadiyang.equator.FieldInfo;
import com.github.dadiyang.equator.GetterBaseEquator;
import lombok.Data;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 对象比较器测试
 *
 * @author zetu
 * @date 2021/5/24
 */
public class ObjectEquatorTest {

    @Test
    public void equatorTest() {
        Equator equator = new GetterBaseEquator();

        User user1 = new User() {{
            setName("");
            setAge(20);
            setSalary(new BigDecimal("100"));
            List<String> hobbies = new ArrayList<>();
            hobbies.add("篮球1");
            hobbies.add("羽毛球");
            Collections.sort(hobbies);
            setHobbies(hobbies);
        }};
        List<User> users1 = new ArrayList<>();
        users1.add(user1);

        User user2 = new User() {{
            setName("Tom");
            setAge(20);
            setSalary(new BigDecimal("100"));
            List<String> hobbies = new ArrayList<>();
            hobbies.add("羽毛球");
            hobbies.add("篮球");
            Collections.sort(hobbies);
            setHobbies(hobbies);
        }};
        List<User> users2 = new ArrayList<>();
        users2.add(user2);

        List<FieldInfo> fields = equator.getDiffFields(user1, user2);
        for (FieldInfo field : fields) {
            System.out.println("1" + field.getFirstFieldType().getName());
            System.out.println("2" + field.getFirstFieldType().getSimpleName());
            System.out.println("3" + Arrays.toString(field.getFirstFieldType().getDeclaredFields()));
        }
        System.out.println(JSON.toJSONString(fields));

        List<FieldInfo> fields2 = equator.getDiffFields(users1, users2);
        System.out.println(JSON.toJSONString(fields2));
    }

    @Data
    public static class User {
        private String name;
        private Integer age;
        private BigDecimal salary;
        private List<String> hobbies;
    }


}
