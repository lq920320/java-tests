package other;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.*;
import java.util.stream.Collectors;

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

    @Test
    public void listCopyTest() {
        List<Employee> employees = getEmployees();
        List<Employee> oldEmployees = employees.stream().map(emp -> {
            Employee employee = new Employee();
            BeanUtils.copyProperties(emp, employee);
            return employee;
        }).collect(Collectors.toList());

//        List<Employee> oldEmployees = new ArrayList<>(employees.size());
//        CollectionUtils.addAll(oldEmployees, new Employee[employees.size()]);
//        Collections.copy(oldEmployees, employees);

        oldEmployees.forEach(emp -> emp.setRemark("worker"));

        System.out.println(JSON.toJSONString(employees));
        System.out.println(JSON.toJSONString(oldEmployees));

    }

    private List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee() {{
            setId(1);
            setName("Tom");
            setGender("MALE");
            setRemark("engineer");
        }};
        employees.add(employee1);
        return employees;
    }

    @Data
    private class Employee {
        private Integer id;
        private String name;
        private String gender;
        private String remark;
    }
}
