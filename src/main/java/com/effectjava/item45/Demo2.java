package com.effectjava.item45;

/**
 * TODO description
 *
 * @author zetu
 * @date 2021/5/27
 */
public class Demo2 {

    public static void main(String[] args) {
        "Hello world!".chars().forEach(System.out::print);
        System.out.println();
        "Hello world!".chars().forEach(x -> System.out.print((char) x));
        System.out.println();
    }
}
