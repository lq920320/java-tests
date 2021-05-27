package com.effectjava.item42;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Comparator.comparingInt;

/**
 * TODO description
 *
 * @author zetu
 * @date 2021/5/26
 */
public class Demo1 {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();

        words.add("BAasdasd");
        words.add("Casdasssssssasd");
        words.add("Uas");
        words.add("Tsdas");
        words.add("Adsade");
        words.add("Wdasdasd");
        System.out.println("排序前：" + JSON.toJSONString(words));
        sort1(words);
        System.out.println("排序后：" + JSON.toJSONString(words));


    }

    private static void sort1(List<String> words) {
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        // replace with lambda
        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        // 具体实现代替构造方法
        Collections.sort(words, comparingInt(String::length));

        // java8 中 List sort 方法
        words.sort(comparingInt(String::length));
    }
}
