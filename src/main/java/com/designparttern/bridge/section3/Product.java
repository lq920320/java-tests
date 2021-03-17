package com.designparttern.bridge.section3;

/**
 * @author zetu
 * @desc
 * @date 2021/3/14
 */
public abstract class Product {

    /**
     * 甭管是什么产品它总要能被生产出来
     */
    public abstract void beProduct();

    /**
     * 生产出来的东西，一定要销售出去，否则亏本
     */
    public abstract void beSold();
}
