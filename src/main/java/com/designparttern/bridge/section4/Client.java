package com.designparttern.bridge.section4;

/**
 * @author zetu
 * @desc
 * @date 2021/3/14
 */
public class Client {

    public static void main(String[] args) {
        // 定义一个实现化角色
        Implementor imp = new ConcreteImplementor1();

        // 定义一个抽象化角色
        Abstraction abs = new RefinedAbstraction(imp);
        // 执行行为
        abs.request();
    }
}
