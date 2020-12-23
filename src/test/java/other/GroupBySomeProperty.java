package other;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        System.out.println(objectMapper.writeValueAsString(scoreList));
        System.out.println(objectMapper.writeValueAsString(gradeList));
    }

    private List<StudentGrade> groupByStu(List<StudentScore> scoreList) {
        List<StudentGrade> gradeList = scoreList.parallelStream().filter(distinctByKey(StudentScore::getStuNum)).map(score -> new StudentGrade() {{
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
