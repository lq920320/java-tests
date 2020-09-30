package other;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.Test;
import org.springframework.boot.context.properties.PropertyMapper;

/**
 * @author liuqian
 * @date 2019/5/16  9:53
 */
public class PropertyMapperTest {

    @Test
    public void propertyMapperTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        PropertyMapper mapper = PropertyMapper.get().alwaysApplyingWhenNonNull();
        Student student1 = new Student() {{
            setId(1);
            setName("TOM-007");
        }};
        System.out.println(objectMapper.writeValueAsString(student1));
        Student student2 = new Student();
        // from(Supplier<T> supplier)
        mapper.from(student1::getId).to(student2::setId);
        mapper.from(student1::getName).to(student2::setName);
        mapper.from(student1::getScore).to(student2::setScore);
        // from(T value)
        mapper.from(80).to(student2::setScore);
        System.out.println(objectMapper.writeValueAsString(student2));
    }

    @Data
    private class Student {
        private Integer id;
        private String name;
        private Integer score;
        private int stuNum;
    }
}

