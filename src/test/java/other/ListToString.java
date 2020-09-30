package other;

import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liuqian
 * @date 2019/4/18  10:30
 */
@Slf4j
public class ListToString {

    @Test
    public void listToStringTest() {
        List<String> strings = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

        System.out.println(String.join(" -> ", strings));
    }

    @Test
    public void stringListReverse() {
        List<String> strings = Stream.of("one", "two", "three", "four").collect(Collectors.toList());
        Collections.reverse(strings);
        System.out.println(strings);
    }

    @Test
    public void arrayToList() {
        Integer[] arrayOne = {1, 2, 3};
        List<Integer> listOne;
        listOne = Arrays.asList(arrayOne);
        try {
            listOne.add(4);
        } catch (UnsupportedOperationException e) {
            log.info("Arrays.asList() 不能添加元素");
        }
        System.out.println(listOne);

        List<Integer> listTwo = new ArrayList<>(arrayOne.length);
        Collections.addAll(listTwo, arrayOne);
        listTwo.add(4);
        System.out.println(listTwo);

        List<Integer> listThree = ImmutableList.of(1, 2, 3);
        try {
            listThree.add(4);
        } catch (UnsupportedOperationException e) {
            log.info("ImmutableList.of() 不能添加元素");
        }

    }
}
