package com.designparttern.bridge.section2;

/**
 * @author zetu
 * @desc
 * @date 2021/3/14
 */
public class IPodCrop extends Crop {
    @Override
    protected void produce() {
        System.out.println("我生产iPod。。。");
    }

    @Override
    protected void sell() {
        // 山寨的iPod很畅销，便宜嘛
        System.out.println("iPod畅销。。。");
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("我赚钱呀。。。");
    }


}
