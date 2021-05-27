package com.effectjava.item43;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO description
 *
 * @author zetu
 * @date 2021/5/27
 */
public class Demo1 {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        List<String> strList = new ArrayList<>();
        strList.add("A");
        strList.add("A");
        strList.add("A");
        strList.add("A");
        strList.add("C");
        strList.add("C");
        strList.add("C");
        strList.add("K");

        for (String s : strList) {
            // lambda
            map.merge(s, 1, (count, inc) -> count + inc);
            // 静态方法
            map2.merge(s, 1, Integer::sum);
        }

        System.out.println(JSON.toJSONString(map));
        System.out.println(JSON.toJSONString(map2));
    }
}
