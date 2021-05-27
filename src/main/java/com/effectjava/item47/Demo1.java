package com.effectjava.item47;

import com.effectjava.item46.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.effectjava.item46.Demo1.getStudentList;

/**
 * TODO description
 *
 * @author zetu
 * @date 2021/5/27
 */
public class Demo1 {

    public static void main(String[] args) {
        List<Student> students = getStudentList();

        long start1 = System.currentTimeMillis();
        Student maxMathStudent = students.stream().max(Comparator.comparing(Student::getMathScore)).orElse(null);
        System.out.println("非并行流耗时：" + (System.currentTimeMillis() - start1) + " ms");

        long start2 = System.currentTimeMillis();
        Student maxMathStudent2 = students.parallelStream().max(Comparator.comparing(Student::getMathScore)).orElse(null);
        System.out.println("并行流耗时：" + (System.currentTimeMillis() - start2) + " ms");
    }
}
