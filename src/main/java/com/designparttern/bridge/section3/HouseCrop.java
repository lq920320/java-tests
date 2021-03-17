package com.designparttern.bridge.section3;

/**
 * @author zetu
 * @desc
 * @date 2021/3/14
 */
public class HouseCrop extends Crop {

    /**
     * 定义传递一个House产品进来
     *
     * @param house
     */
    public HouseCrop(House house) {
        super(house);
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("房地产公司赚大钱了。。。");
    }
}
