package other;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 列表排序
 *
 * @author zetu
 * @date 2021/6/1
 */
public class ListSortTest {

    @Test
    public void listSort() {
        List<Integer> aList = getTestList();

        System.out.println("排序前：");
        aList.forEach(a -> System.out.printf("%4d", a));
        System.out.println("\n排序后：");
        // 创建一个新列表
        aList = aList.stream().sorted().collect(Collectors.toList());
        // 使用 List 实现的 sort 方法
        aList.sort(Comparator.comparing(a -> a));

        aList.forEach(a -> System.out.printf("%4d", a));
        System.out.println();
    }

    @Test
    public void listNullTest() {
        List<Integer> aList = getTestListWithNull();

        System.out.println("排序前：");
        aList.forEach(a -> {
            if (a != null) {
                System.out.printf("%4d", a);
            } else {
                System.out.printf("%8s", a);
            }
        });
        System.out.println("\n排序后：");
        // 正常的排序会报错
        // aList.sort(Comparator.comparing(a -> a)); // throw NPE
        aList = aList.stream().sorted(
                // nullsLast() / nullsFirst()
                // 对应的整个列表的顺序为： Comparator.naturalOrder() 正序；Comparator.reverseOrder() 反序
                Comparator.comparing(a -> a, Comparator.nullsLast(Comparator.naturalOrder()))
        ).collect(Collectors.toList());
        aList.forEach(a -> {
            if (a != null) {
                System.out.printf("%4d", a);
            } else {
                System.out.printf("%8s", a);
            }
        });
        System.out.println();
    }

    @Test
    public void listInSomeOrderTest() {
        List<String> seasons = new ArrayList<>();
        seasons.add("夏");
        seasons.add("冬");
        seasons.add("春");
        seasons.add("秋");

        System.out.println("排序前：");
        seasons.forEach(s -> System.out.printf("%4s", s));
        System.out.println("\n一般排序后：");
        seasons = seasons.stream().sorted().collect(Collectors.toList());
        seasons.forEach(s -> System.out.printf("%4s", s));
        System.out.println();

        // 固定顺序
        List<String> theOrders = Arrays.asList("春", "夏", "秋", "冬");
        // 按照 theOrders 排序
        seasons = seasons.stream().sorted(Comparator.comparing(theOrders::indexOf)).collect(Collectors.toList());
        System.out.println("按照固定顺序排序后：");
        seasons.forEach(s -> System.out.printf("%4s", s));
        System.out.println();
    }

    @Test
    public void listWithFieldsTest() throws JsonProcessingException {
        // 根据年纪升序，根据薪水降序，得到一个有序的列表
        // 排序条件逆序设置：先排序的条件放在后面，后排序的条件放前面
        ObjectMapper objectMapper = new ObjectMapper();
        List<Worker> testWorkers = getTestDatas();
        // 原顺序
        System.out.println("排序前：");
        for (Worker testWorker : testWorkers) {
            System.out.println(objectMapper.writeValueAsString(testWorker));
        }
        // 排序后
        List<Worker> sortedWorkers = testWorkers.stream()
                // 薪水倒序
                .sorted(Comparator.comparing(Worker::getSalary, Comparator.reverseOrder()))
                .sorted(Comparator.comparing(Worker::getAge))
                .collect(Collectors.toList());
        System.out.println("排序后：");
        for (Worker sortedWorker : sortedWorkers) {
            System.out.println(objectMapper.writeValueAsString(sortedWorker));
        }
    }

    private List<Integer> getTestList() {
        List<Integer> aList = new ArrayList<>();
        aList.add(2);
        aList.add(3);
        aList.add(9);
        aList.add(8);
        aList.add(5);
        aList.add(1);
        aList.add(4);
        aList.add(7);
        aList.add(6);
        return aList;
    }

    private List<Integer> getTestListWithNull() {
        List<Integer> aList = new ArrayList<>();
        aList.add(2);
        aList.add(3);
        aList.add(9);
        aList.add(null);
        aList.add(8);
        aList.add(5);
        aList.add(null);
        aList.add(1);
        aList.add(4);
        aList.add(null);
        aList.add(7);
        aList.add(6);
        aList.add(null);
        return aList;
    }

    private List<Worker> getTestDatas() {
        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker() {{
            setId(1);
            setAge(20);
            setSalary(1000);
        }});
        workers.add(new Worker() {{
            setId(2);
            setAge(22);
            setSalary(1200);
        }});
        workers.add(new Worker() {{
            setId(3);
            setAge(20);
            setSalary(800);
        }});
        workers.add(new Worker() {{
            setId(4);
            setAge(20);
            setSalary(700);
        }});
        workers.add(new Worker() {{
            setId(5);
            setAge(22);
            setSalary(1800);
        }});
        workers.add(new Worker() {{
            setId(6);
            setAge(21);
            setSalary(1100);
        }});
        workers.add(new Worker() {{
            setId(7);
            setAge(22);
            setSalary(1600);
        }});
        workers.add(new Worker() {{
            setId(8);
            setAge(21);
            setSalary(1200);
        }});
        workers.add(new Worker() {{
            setId(9);
            setAge(20);
            setSalary(600);
        }});
        workers.add(new Worker() {{
            setId(10);
            setAge(20);
            setSalary(1200);
        }});
        workers.add(new Worker() {{
            setId(11);
            setAge(21);
            setSalary(1500);
        }});
        workers.add(new Worker() {{
            setId(12);
            setAge(20);
            setSalary(400);
        }});
        workers.add(new Worker() {{
            setId(13);
            setAge(20);
            setSalary(1100);
        }});
        workers.add(new Worker() {{
            setId(14);
            setAge(21);
            setSalary(1500);
        }});
        workers.add(new Worker() {{
            setId(15);
            setAge(21);
            setSalary(1600);
        }});
        return workers;
    }

    @Data
    private static class Worker {
        /**
         * ID
         */
        private Integer id;
        /**
         * 年纪
         */
        private Integer age;
        /**
         * 薪水
         */
        private Integer salary;
    }

}
