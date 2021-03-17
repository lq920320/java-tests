package com.designparttern.bridge.section2;

/**
 * @author zetu
 * @desc
 * @date 2021/3/14
 */
public abstract class Crop {

    /**
     * 是公司就应该有生产
     * 生产的东西有实现类来决定
     */
    protected abstract void produce();

    /**
     * 生产好的产品同时也要销售出去
     */
    protected abstract void sell();

    /**
     * 公司是干什么的？赚钱的
     */
    public void makeMoney() {
        this.produce();
        this.sell();
    }


}
