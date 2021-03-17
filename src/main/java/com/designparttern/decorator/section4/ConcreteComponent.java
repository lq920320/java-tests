package com.designparttern.decorator.section4;

/**
 * @author zetu
 * @desc
 * @date 2021/3/17
 */
public class ConcreteComponent extends Component {
    /**
     * 具体实现
     */
    @Override
    public void operate() {
        System.out.println("do something....");
    }
}
