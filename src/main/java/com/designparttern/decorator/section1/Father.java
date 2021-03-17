package com.designparttern.decorator.section1;

/**
 * @author zetu
 * @desc
 * @date 2021/3/16
 */
public class Father {

    public static void main(String[] args) {
        // 把成绩单拿过来
        // 里氏替换
        SchoolReport sr = new FourthGradeSchoolReport();
        // 看成绩单
        sr.report();
        // 签名？休想！
    }
}
