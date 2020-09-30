package com.ai;

import java.util.Scanner;

/**
 * @author liuqian
 * @date 2019/7/17  16:23
 */
public class AiMan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while (true) {
            str = sc.nextLine();
            str = str.replace("你", "我");
            str = str.replace("吗", "");
            str = str.replace("?", "!");
            str = str.replace("？", "！");
            System.out.println(str);
        }
    }
}
