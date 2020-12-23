package lambda;

import org.junit.Test;

import java.util.function.Function;

import static java.util.stream.IntStream.range;

/**
 * @author liuqian
 * @date 2019/7/19  17:15
 */
public class LambdaTest {

    @Test
    public void functionTest() {
        Function<Integer, Integer> function = e -> e * 6;
        // 2 * 6
        System.out.println(function.apply(2));

        Function<Integer, Integer> function1 = e -> e * 2;
        Function<Integer, Integer> function2 = e -> e * e;

        // 组合顺序，放在后面的先算 : (3 * 3) * 2
        Integer apply2 = function1.compose(function2).apply(3);
        System.out.println(apply2);
        // 组合顺序，放在后面的先算 : (3 * 2) * (3 * 2)
        Integer apply3 = function2.compose(function1).apply(3);
        System.out.println(apply3);

        // 先后顺序，先计算function1，再计算 function2 : (3 * 2) * (3 * 2)
        Integer apply4 = function1.andThen(function2).apply(3);
        System.out.println(apply4);
    }

    @Test
    public void rangeTest() {
        // range 函数
        range(1, 10).forEach(System.out::println);
    }
}
