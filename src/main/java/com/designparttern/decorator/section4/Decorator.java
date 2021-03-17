package com.designparttern.decorator.section4;

/**
 * @author zetu
 * @desc
 * @date 2021/3/17
 */
public class Decorator extends Component {
    private Component component = null;

    /**
     * 通过构造函数传递被修饰者
     *
     * @param component
     */
    public Decorator(Component component) {
        this.component = component;
    }

    /**
     * 委托给被修饰者执行
     */
    @Override
    public void operate() {
        this.component.operate();
    }
}
