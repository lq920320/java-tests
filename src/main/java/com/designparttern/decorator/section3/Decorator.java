package com.designparttern.decorator.section3;

/**
 * @author zetu
 * @desc
 * @date 2021/3/16
 */
public abstract class Decorator extends SchoolReport {
    /**
     * 首先我要知道是那个成绩单
     */
    private SchoolReport sr;

    /**
     * 构造函数，传成绩单过来
     *
     * @param sr
     */
    public Decorator(SchoolReport sr) {
        this.sr = sr;
    }

    /**
     * 成绩单还是要被看到的
     */
    @Override
    public void report() {
        this.sr.report();
    }

    /**
     * 看完还是要签名的
     *
     * @param name 家长姓名
     */
    @Override
    public void sign(String name) {
        this.sr.sign(name);
    }
}
