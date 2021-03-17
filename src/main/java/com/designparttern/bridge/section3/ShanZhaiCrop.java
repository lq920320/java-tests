package com.designparttern.bridge.section3;

/**
 * @author zetu
 * @desc
 * @date 2021/3/14
 */
public class ShanZhaiCrop extends Crop {
    /**
     * 产什么产品，不知道，等被调用才知道
     *
     * @param product
     */
    public ShanZhaiCrop(Product product) {
        super(product);
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("我赚钱呀。。。");
    }
}
