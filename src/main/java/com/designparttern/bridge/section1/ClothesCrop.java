package com.designparttern.bridge.section1;

/**
 * @author zetu
 * @desc
 * @date 2021/3/14
 */
public class ClothesCrop extends Crop {
    @Override
    protected void produce() {
        // 服装公司生产衣服
        System.out.println("服装公司生产衣服。。。");
    }

    @Override
    protected void sell() {
        // 服装公司卖衣服
        System.out.println("服装公司卖衣服。。。");
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("服装公司赚小钱。。。");
    }
}
