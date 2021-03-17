package com.designparttern.decorator.section2;

/**
 * @author zetu
 * @desc
 * @date 2021/3/16
 */
public class SugarFourthGradeSchoolReport extends FourthGradeSchoolReport {

    /**
     * 首先要定义你要美化的方法，先说学校最高成绩
     */
    private void reportHighScore() {
        System.out.println("这次考试语文最该是75，数学是78，自然是80");
    }

    /**
     * 在老爸看完成绩单后，我再回报学校的排名情况
     */
    private void reportSort() {
        System.out.println("我是排名第38名。。。");
    }

    /**
     * 由于汇报的内容已经发生变更，那所以要重写父类
     */
    @Override
    public void report() {
        // 先说最高成绩
        this.reportHighScore();
        // 然后老爸看成绩单
        super.report();
        // 然后告诉老爸排名
        this.reportSort();
    }
}
