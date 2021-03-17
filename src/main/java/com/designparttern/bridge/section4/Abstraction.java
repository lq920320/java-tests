package com.designparttern.bridge.section4;

/**
 * @author zetu
 * @desc 抽象化角色
 * @date 2021/3/14
 */
public class Abstraction {
    /**
     * 定义对实现化角色对引用
     */
    private Implementor impl;

    /**
     * 约束子类必须实现该构造函数
     * 为什么要增加一个构造函数？答案是为了提醒子类，你必须做这项工作，指定实现者，也别是已经明确了实现者，则尽量清晰明确地定义出来
     */
    public Abstraction(Implementor impl) {
        this.impl = impl;
    }

    /**
     * 自身行为和属性
     */
    public void request() {
        this.impl.doSomething();
    }

    /**
     * 获得实现化角色
     *
     * @return
     */
    public Implementor getImpl() {
        return this.impl;
    }

}
