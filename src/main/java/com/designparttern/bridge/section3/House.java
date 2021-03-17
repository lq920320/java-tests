package com.designparttern.bridge.section3;

/**
 * @author zetu
 * @desc
 * @date 2021/3/14
 */
public class House extends Product {
    @Override
    public void beProduct() {
        System.out.println("生产出的房子是这样的。。。");
    }

    @Override
    public void beSold() {
        System.out.println("生产出的房子被卖出去了。。。");
    }
}
