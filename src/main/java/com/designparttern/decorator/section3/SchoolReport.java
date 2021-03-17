package com.designparttern.decorator.section3;

/**
 * @author zetu
 * @desc
 * @date 2021/3/16
 */
public abstract class SchoolReport {

    /**
     * 成绩单主要展示的就是你的成绩情况
     */
    public abstract void report();

    /**
     * 成绩单要家长签字，这个是最要命的
     *
     * @param name 家长姓名
     */
    public abstract void sign(String name);
}
