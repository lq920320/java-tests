package com.effectjava.item46;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * TODO description
 *
 * @author zetu
 * @date 2021/5/27
 */
public class Demo1 {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Student> studentList = getStudentList();

        // toMap
        Map<String, Integer> group1 = studentList.stream().collect(
                Collectors.toMap(Student::getName, Student::getMathScore, Integer::sum)
        );

        // group
        Map<String, Integer> groupList = studentList.stream().collect(
                groupingBy(Student::getName, summingInt(Student::getMathScore))
        );

        // toSet
        Set<Student> set1 = studentList.stream().collect(toSet());

        // joining
        List<String> list = Arrays.asList("A", "B", "C", "D");
        String result = list.stream().collect(Collectors.joining("-"));

        try {
            System.out.println("toMap: " + objectMapper.writeValueAsString(group1));
            System.out.println("groupingBy: " + objectMapper.writeValueAsString(groupList));
            System.out.println("joining: " + result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


    public static List<Student> getStudentList() {
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
