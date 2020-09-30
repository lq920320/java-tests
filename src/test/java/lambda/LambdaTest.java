package lambda;

import org.junit.Test;

import java.util.function.Function;

/**
 * @author liuqian
 * @date 2019/7/19  17:15
 */
public class LambdaTest {

    @Test
    public void functionTest() {
        Function<Integer, Integer> function = e -> e * 6;
        System.out.println(function.apply(2));

        Function<Integer, Integer> function1 = e -> e * 2;
        Function<Integer, Integer> function2 = e -> e * e;

        Integer apply2 = function1.compose(function2).apply(3);
        System.out.println(apply2);

        Integer apply3 = function1.andThen(function2).apply(3);
        System.out.println(apply3);
    }
}
