package com.designparttern.decorator.section3;

/**
 * 最高成绩修饰
 *
 * @author zetu
 * @date 2021/3/16
 */
public class HighScoreDecorator extends Decorator {


    /**
     * 构造函数，传成绩单过来
     *
     * @param sr
     */
    public HighScoreDecorator(SchoolReport sr) {
        super(sr);
    }

    /**
     * 汇报最高成绩
     */
    private void reportHighScore() {
        System.out.println("这次考试语文最高是75，数学是78，自然是80");
    }

    /**
     * 先汇报最高成绩
     */
    @Override
    public void report() {
        this.reportHighScore();
        super.report();
    }
}
