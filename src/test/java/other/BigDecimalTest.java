package other;

import org.apache.commons.lang3.ObjectUtils;
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
    public void decimalEqual() {
        BigDecimal decimal1 = new BigDecimal("12");
        BigDecimal decimal2 = new BigDecimal("12.000");
        System.out.println(ObjectUtils.notEqual(decimal1, decimal2));
        System.out.println(decimal1.compareTo(decimal2));
    }

    @Test
    public void intStrParse() {
        String a = "1022";
        System.out.println(Integer.valueOf(a));
    }

    @Test
    public void someMethod() {
        BigDecimal a = new BigDecimal("1E11");

        System.out.println(a);
        // 不使用任何指数
        System.out.println(a.toPlainString());

        // 有必要时使用科学计数法
        System.out.println(a.toString());

        // 有必要时使用工程计数法。工程记数法是一种工程计算中经常使用的记录数字的方法，与科学技术法类似，但要求10的幂必须是3的倍数
        System.out.println(a.toEngineeringString());

        System.out.println(a.stripTrailingZeros());
    }
}
