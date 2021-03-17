package com.designparttern.decorator.section2;

/**
 * @author zetu
 * @desc
 * @date 2021/3/16
 */
public class Father {

    public static void main(String[] args) {
        // 把美化过的成绩单拿过来
        SchoolReport sr = new SugarFourthGradeSchoolReport();
        // 看成绩单
        sr.report();
        // 然后老爸一看，很开心，就签名来
        sr.sign("老三");
    }
}
