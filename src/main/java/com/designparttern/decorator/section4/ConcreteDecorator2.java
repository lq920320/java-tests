package com.designparttern.decorator.section4;

/**
 * @author zetu
 * @desc
 * @date 2021/3/17
 */
public class ConcreteDecorator2 extends Decorator {
    /**
     * 通过构造函数传递被修饰者
     *
     * @param component
     */
    public ConcreteDecorator2(Component component) {
        super(component);
    }

    /**
     * 定义自己的修饰方法
     */
    private void method2() {
        System.out.println("method2 修饰");
    }

    /**
     * 重写父类的 operate 方法
     */
    @Override
    public void operate() {
        super.operate();
        this.method2();
    }
}
