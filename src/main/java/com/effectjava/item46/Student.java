package com.effectjava.item46;

import lombok.Data;

/**
 * TODO description
 *
 * @author zetu
 * @date 2021/5/27
 */
@Data
public class Student {
    private String name;
    private Integer mathScore;
    private Integer chineseScore;
    private Integer englishScore;

    @Override
    public String toString() {
        return "Student: name is " + name + ", mathScore is " + mathScore +
                ", chineseScore is " + chineseScore +
                ", englishScore is " + englishScore;
    }
}
