package com.designparttern.bridge.section3;

/**
 * @author zetu
 * @desc
 * @date 2021/3/14
 */
public abstract class Crop {

    /**
     * 定义一个抽象的产品对象，不知道具体是什么产品
     */
    private Product product;

    /**
     * 构造函数，由子类定义传递具体的产品进来
     */
    public Crop(Product product) {
        this.product = product;
    }

    /**
     * 公司是干什么的？赚钱的
     */
    public void makeMoney() {
        this.product.beProduct();
        this.product.beSold();
    }


}
