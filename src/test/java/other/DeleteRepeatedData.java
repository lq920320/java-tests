package other;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author liuqian
 * @date 2019/5/5  13:23
 */
public class DeleteRepeatedData {

    @Test
    public void singleDataList() throws JsonProcessingException {
        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("A");
        stringList.add("A");
        stringList.add("A");
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");
        stringList.add("D");
        stringList = stringList.stream().distinct().collect(Collectors.toList());
        System.out.println(stringList);

        ObjectMapper objectMapper = new ObjectMapper();
        List<Employee> employeeList = getEmployees();
        System.out.println(objectMapper.writeValueAsString(employeeList));
        employeeList = employeeList.stream().distinct().collect(Collectors.toList());
        System.out.println(objectMapper.writeValueAsString(employeeList));

    }


    @Test
    public void distinctByKeyTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Employee> employeeList = getEmployees();
        System.out.println(objectMapper.writeValueAsString(employeeList));

        List<Employee> employees = employeeList.stream().filter(distinctByKey(Employee::getId)).collect(Collectors.toList());
        System.out.println(objectMapper.writeValueAsString(employees));

        List<Employee> employees2 = employeeList.stream().filter(distinctByKey2(Employee::getId)).collect(Collectors.toList());
        System.out.println(objectMapper.writeValueAsString(employees2));
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    private static <T> Predicate<T> distinctByKey2(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = new HashSet<>();
        return t -> seen.add(keyExtractor.apply(t));
    }

    private List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee() {{
            setId(1);
            setName("Tom");
            setGender("MALE");
            setRemark("engineer");
        }};
        Employee employee2 = new Employee() {{
            setId(2);
            setName("Jerry");
            setGender("MALE");
            setRemark("manager");
        }};
        Employee employee3 = new Employee() {{
            setId(3);
            setName("Mike");
            setGender("MALE");
            setRemark("manager");
        }};
        Employee employee4 = new Employee() {{
            setId(1);
            setName("Tom");
            setGender("MALE");
            setRemark("engineer");
        }};
        Employee employee5 = new Employee() {{
            setId(4);
            setName("Lily");
            setGender("FEMALE");
            setRemark("manager");
        }};
        Employee employee6 = new Employee() {{
            setId(5);
            setName("Hunter");
            setGender("MALE");
            setRemark("engineer");
        }};
        Employee employee7 = new Employee() {{
            setId(6);
            setName("Julia");
            setGender("FEMALE");
            setRemark("engineer");
        }};
        Employee employee8 = new Employee() {{
            setId(1);
            setName("Tom");
            setGender("MALE");
            setRemark("engineer");
        }};
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);
        employees.add(employee8);
        employees.add(employee1);
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
