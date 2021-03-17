package com.designparttern.bridge.section3;

/**
 * @author zetu
 * @desc
 * @date 2021/3/14
 */
public class Clothes extends Product {
    @Override
    public void beProduct() {
        System.out.println("生产出的衣服是这样的。。。");
    }

    @Override
    public void beSold() {
        System.out.println("生产出的衣服卖出去了。。。");
    }
}
