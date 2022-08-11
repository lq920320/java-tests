package other;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * @author zetu
 * @desc
 * @date 2021/3/16
 */
public class DecimalCal {

    @Test
    public void decimalCal() {
        BigDecimal num = new BigDecimal("-50");
        BigDecimal times = (num.add(new BigDecimal("100"))).divide(new BigDecimal("100"));
        BigDecimal result = mul(0, RoundingMode.HALF_EVEN, new BigDecimal("999999.99"),
                times);

        System.out.println(result);


    }

    public static BigDecimal mul(int scale, RoundingMode roundingMode, BigDecimal... multiplies) {
        BigDecimal one = new BigDecimal(1);
        BigDecimal r = new BigDecimal(1);
        BigDecimal[] var5 = multiplies;
        int var6 = multiplies.length;

        for (int var7 = 0; var7 < var6; ++var7) {
            BigDecimal b = var5[var7];
            r = r.multiply(null == b ? one : b);
        }

        return r.setScale(scale, roundingMode);
    }


    @Test
    public void cal() {
        String downloadDisFileLimitStr = "1610612736";
        long downloadDisFileLimit = Long.parseLong(downloadDisFileLimitStr);
        String limitStr;
        float a = (float) downloadDisFileLimit / 1024 / 1024 / 1024;
        limitStr = a + "GB";
        System.out.println(limitStr);

        float b = (float) (downloadDisFileLimit / 1024 / 1024);
        limitStr = b + "MB";
        System.out.println(limitStr);

    }
}
