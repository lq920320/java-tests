package other;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

/**
 * @author liuqian
 * @date 2019/4/23  14:17
 */
@Slf4j
public class CollectionsTest {

    /**
     * 是否Collectors.toList()一定不会为空
     * <p>
     * 答案是是的， toList() 方法会新创建一个列表
     */
    @Test
    public void collectionsTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<String> stringList = new ArrayList<String>() {{
            add("A");
            add("B");
            add("c");
            add("d");
            add("e");
            add("f");
            add("g");
        }};

        List<String> filterStrings = stringList.stream().filter(str -> str.equals("KK")).collect(Collectors.toList());

        System.out.println(objectMapper.writeValueAsString(filterStrings));
        System.out.println(filterStrings.size());
        System.out.println(filterStrings.isEmpty());
        System.out.println(CollectionUtils.isEmpty(filterStrings));
    }

    @Test
    public void unmodifiableList() {
        List<String> stringList = new ArrayList<String>() {{
            add("A");
            add("B");
            add("c");
            add("d");
            add("e");
            add("f");
            add("g");
        }};

        List<String> unmodifiableList = Collections.unmodifiableList(stringList);
        // Throw UnsupportedOperationException
        // unmodifiableList.add("F");

        System.out.println(unmodifiableList);
    }

    @Test
    public void arrayToList() {
        String[] array = {"1", "2"};
        List<String> strings = Arrays.asList(array);
        try {
            strings.add("3");
        } catch (UnsupportedOperationException e) {
            log.error("不可进行add, remove 操作，构造了一个定长不可变的列表");
            System.out.println(strings);
        }

        System.out.println("-------------------------");
        List<String> strings2 = new ArrayList<>(array.length);
        Collections.addAll(strings2, array);
        System.out.println(strings2);
        strings2.add("3");
        System.out.println(strings2);

        System.out.println("-------------------------");
        List<String> string3 = new ArrayList<>(Arrays.asList(array));
        System.out.println(string3);
        string3.add("3");
        System.out.println(string3);
    }

    @Test
    public void groupingTest() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Student> studentList = getStudentList();
        Map<String, Integer> groupList = studentList.stream().collect(
                groupingBy(Student::getName, summingInt(Student::getMathScore))
        );
        try {
            System.out.println(objectMapper.writeValueAsString(groupList));
            System.out.println(groupList.keySet());
            System.out.println(groupList.values());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void maxTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Student> studentList = getStudentList();
        Student maxMathScoreStudent = studentList.stream()
                .max(Comparator.comparing(Student::getMathScore)).orElse(null);
        System.out.println(objectMapper.writeValueAsString(maxMathScoreStudent));
    }

    @Test
    public void filterAndMapTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Student> studentList = getStudentList();
        List<String> studentNames = studentList.stream().filter(student -> student.getMathScore() != null && student.getMathScore() > 30).map(Student::getName).collect(Collectors.toList());
        System.out.println(objectMapper.writeValueAsString(studentNames));
    }

    @Data
    private class Student {
        private String name;
        private Integer mathScore;
        private Integer chineseScore;
        private Integer englishScore;

        @Override
        public String toString() {
            return "Student: name is " + name + ", mathScore is " + mathScore +
                    ", chineseScore is " + chineseScore +
                    ", englishScore is " + englishScore;
        }
    }

    private List<Student> getStudentList() {
        return new ArrayList<Student>() {{
            add(new Student() {{
                setName("Mike");
                setMathScore(10);
                setChineseScore(10);
                setEnglishScore(10);
            }});
            add(new Student() {{
                setName("Mike");
                setMathScore(20);
                setChineseScore(20);
                setEnglishScore(20);
            }});
            add(new Student() {{
                setName("Mike");
                setMathScore(5);
                setChineseScore(5);
                setEnglishScore(5);
            }});
            add(new Student() {{
                setName("Jack");
                setMathScore(10);
                setChineseScore(10);
                setEnglishScore(10);
            }});
            add(new Student() {{
                setName("Tom");
                setMathScore(5);
                setChineseScore(5);
                setEnglishScore(5);
            }});
        }};
    }
}
