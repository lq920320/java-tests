package other;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author liuqian
 * @date 2020/10/10 15:27
 */
public class BigDecimalTest {

    @Test
    public void bigDecimalTest() {
        BigDecimal decimal = new BigDecimal("123");
        BigDecimal decimal2 = new BigDecimal("0");

        System.out.println(decimal.compareTo(BigDecimal.ZERO));
        System.out.println(decimal2.compareTo(BigDecimal.ZERO));

        // 等于一个常数会有警告提示：Comparison of compare method result with specific constant
        System.out.println(decimal.compareTo(BigDecimal.ZERO) == 1);
        // 建议做法
        System.out.println(decimal.compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    public void decimalCalculate() {
        BigDecimal decimal1 = new BigDecimal("12");
        BigDecimal decimal2 = new BigDecimal("4.56");
        BigDecimal result = decimal1.divide(decimal2, 1, RoundingMode.HALF_UP);
        BigDecimal result2 = decimal1.divide(decimal2, 5, RoundingMode.HALF_UP);
        System.out.println(result);
        System.out.println(result2);
    }

    @Test
    public void intStrParse() {
        String a = "1022";
        System.out.println(Integer.valueOf(a));
    }
}
