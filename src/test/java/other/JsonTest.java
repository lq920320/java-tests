package other;

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

    @Data
    private class Employee {
        private String empNO;
        private String name;
        private Integer age;
        private String email;
    }
}
