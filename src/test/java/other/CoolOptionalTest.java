package other;

import org.junit.Test;

import java.util.Optional;
import java.util.OptionalDouble;

/**
 * Optional的一些用法
 *
 * @author zetu
 * @date 2022/1/20
 */
public class CoolOptionalTest {

    @Test
    public void optionalTest() {
        // 直接返回值
        System.out.println(Optional.of(1).get());
        // 为空时返回数据
        System.out.println(Optional.ofNullable(null).orElse("value is null"));
        // false，同理还有 OptionalInt 等，每个这样的对象包含 isPresent、value 两个参数
        System.out.println(OptionalDouble.empty().isPresent());
        // 后面可以接 map()
        System.out.println(Optional.of(1).map(Math::incrementExact).get());
        // 还可以接 filter()，下面的结果为 null
        System.out.println(Optional.of(1).filter(i -> (i % 2 == 0)).orElse(null));
    }

}
