package other;

import lombok.Data;
import org.junit.Test;
import sun.security.acl.AclEntryImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author liuqian
 * @date 2019/6/17  16:43
 */
public class ListSetTest {

    @Test
    public void listSetTest() {
        List<Long> oldList = new ArrayList<Long>() {{
            add(1L);
            add(2L);
            add(3L);
            add(4L);
            add(5L);
        }};
        List<Long> newList = new ArrayList<Long>() {{
            add(4L);
            add(5L);
            add(6L);
        }};

        Set<Long> oldSet = new HashSet<>(oldList);
        Set<Long> newSet = new HashSet<>(newList);

        Set<Long> result = new HashSet<>(oldSet);
        result.removeAll(newSet);
        System.out.println("oldSet 与 newSet 的差集，要删除的数据：" + result);

        result.clear();
        result.addAll(newSet);
        result.removeAll(oldSet);
        System.out.println("newSet 与 oldSet 的差集，要插入的数据：" + result);
    }

    @Test
    public void listAddTest() {
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();

        a.removeAll(b);
    }

    @Test
    public void changeListOfObject() {
        Person person = new Person();
        List<String> habits = new ArrayList<String>() {{
            add("A");
            add("B");
            add("C");
        }};

        person.setHabits(habits);

        List<String> h = person.getHabits();

        System.out.println(h);

        changeList(habits, person);
        h = person.getHabits();
        System.out.println(h);
        System.out.println(person.getHabits());
    }

    private void changeList(List<String> habits, Person person) {
        habits = habits.stream().limit(2).collect(Collectors.toList());
        person.setHabits(habits);
    }


    @Data
    static class Person {
        private List<String> habits;
    }
}
