package other;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author liuqian
 * @date 2019/5/30  10:17
 */
public class GroupBySomeProperty {

    @Test
    public void groupByTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<StudentScore> scoreList = getTestData();
        List<StudentGrade> gradeList = groupByStu(scoreList);
        List<StudentGrade> gradeList2 = groupByStu2(scoreList);

        System.out.println(objectMapper.writeValueAsString(scoreList));
        long startTime1 = System.currentTimeMillis();
        System.out.println(objectMapper.writeValueAsString(gradeList));
        long endTime1 = System.currentTimeMillis();
        System.out.println("group by 1 spend time: " + (endTime1 - startTime1) + " ms");
        // groupingBy() is better
        long startTime2 = System.currentTimeMillis();
        System.out.println(objectMapper.writeValueAsString(gradeList2));
        long endTime2 = System.currentTimeMillis();
        System.out.println("group by 2 spend time: " + (endTime2 - startTime2) + " ms");
    }

    private List<StudentGrade> groupByStu(List<StudentScore> scoreList) {
        List<StudentGrade> gradeList = scoreList.stream().filter(distinctByKey(StudentScore::getStuNum)).map(score -> new StudentGrade() {{
            setStuNum(score.getStuNum());
            setStuName(score.getStuName());
        }}).collect(Collectors.toList());
        gradeList.forEach(grade -> {
            List<CourseScore> tempCourseScoreList = scoreList.stream()
                    .filter(score -> score.getStuNum().equals(grade.stuNum))
                    .map(score -> new CourseScore() {{
                        setCourse(score.getCourse());
                        setScore(score.getScore());
                    }}).collect(Collectors.toList());
            grade.setCourseScoreList(tempCourseScoreList);
        });
        return gradeList;
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }


    private List<StudentGrade> groupByStu2(List<StudentScore> scoreList) {
        Map<String, List<StudentScore>> stuScoreMap = scoreList.stream().collect(
                groupingBy(StudentScore::getStuNum)
        );
        Set<String> keySet = stuScoreMap.keySet();

        return keySet.stream().map(stuNum -> {
            StudentGrade studentGrade = new StudentGrade();
            studentGrade.setStuNum(stuNum);
            List<StudentScore> studentScores = stuScoreMap.get(stuNum);
            if (CollectionUtils.isEmpty(studentScores)) {
                return null;
            }
            studentGrade.setStuName(studentScores.get(0).getStuName());
            List<CourseScore> tempCourseScoreList = studentScores.stream().map(
                    score -> new CourseScore() {{
                        setCourse(score.getCourse());
                        setScore(score.getScore());
                    }}).collect(Collectors.toList());

            studentGrade.setCourseScoreList(tempCourseScoreList);

            return studentGrade;
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    private List<StudentScore> getTestData() {
        StudentScore student1 = new StudentScore() {{
            setStuNum("001");
            setStuName("Tom");
            setCourse("语文");
            setScore(65);
        }};
        StudentScore student2 = new StudentScore() {{
            setStuNum("001");
            setStuName("Tom");
            setCourse("数学");
            setScore(80);
        }};
        StudentScore student3 = new StudentScore() {{
            setStuNum("001");
            setStuName("Tom");
            setCourse("英语");
            setScore(88);
        }};
        StudentScore student4 = new StudentScore() {{
            setStuNum("002");
            setStuName("Mike");
            setCourse("语文");
            setScore(70);
        }};
        StudentScore student5 = new StudentScore() {{
            setStuNum("002");
            setStuName("Mike");
            setCourse("数学");
            setScore(85);
        }};
        StudentScore student6 = new StudentScore() {{
            setStuNum("002");
            setStuName("Mike");
            setCourse("英语");
            setScore(90);
        }};
        StudentScore student7 = new StudentScore() {{
            setStuNum("003");
            setStuName("Lucy");
            setCourse("语文");
            setScore(70);
        }};
        StudentScore student8 = new StudentScore() {{
            setStuNum("003");
            setStuName("Lucy");
            setCourse("数学");
            setScore(60);
        }};

        return new ArrayList<StudentScore>() {{
            add(student1);
            add(student2);
            add(student3);
            add(student4);
            add(student5);
            add(student6);
            add(student7);
            add(student8);
        }};
    }

    @Data
    private static class StudentGrade {
        private String stuNum;
        private String stuName;
        private List<CourseScore> courseScoreList;
    }

    @Data
    private static class CourseScore {
        private String course;
        private Integer score;
    }

    @Data
    private static class StudentScore {
        private String stuNum;
        private String stuName;
        private String course;
        private Integer score;
    }
}
