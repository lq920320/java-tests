package com.designparttern.bridge.section1;

/**
 * @author zetu
 * @desc
 * @date 2021/3/14
 */
public class HouseCrop extends Crop {

    @Override
    protected void produce() {
        // 房地产公司盖房子
        System.out.println("房地产公司盖房子。。。");
    }

    @Override
    protected void sell() {
        // 房地产公司卖房子
        System.out.println("房地产公司卖房子。。。");
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("房地产公司赚大钱了。。。");
    }
}
