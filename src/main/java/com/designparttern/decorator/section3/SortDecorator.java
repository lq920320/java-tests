package com.designparttern.decorator.section3;

/**
 * @author zetu
 * @desc
 * @date 2021/3/16
 */
public class SortDecorator extends Decorator {
    /**
     * 构造函数，传成绩单过来
     *
     * @param sr
     */
    public SortDecorator(SchoolReport sr) {
        super(sr);
    }

    /**
     * 告诉老爸学校的排名情况
     */
    private void reportSort() {
        System.out.println("我是排名第38名...");
    }

    /**
     * 老爸看完成绩单之后再告诉他排名，加强作用
     */
    @Override
    public void report() {
        super.report();
        this.reportSort();
    }
}
