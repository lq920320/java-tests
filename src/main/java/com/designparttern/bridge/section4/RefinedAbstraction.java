package com.designparttern.bridge.section4;

/**
 * @author zetu
 * @desc 具体抽象化角色
 * @date 2021/3/14
 */
public class RefinedAbstraction extends Abstraction {


    /**
     * 覆盖构造函数
     * 想想看，如果我们的实现化角色有很多的子接口，然后是一堆的子实现。如果在构造函数中不传递一个尽量明确的实现者，代码就很不清晰。
     *
     * @param impl
     */
    public RefinedAbstraction(Implementor impl) {
        super(impl);
    }

    /**
     * 修正父类对行为
     */
    @Override
    public void request() {
        super.request();
        super.getImpl().doAnything();
    }
}
