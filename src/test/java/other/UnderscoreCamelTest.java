package other;

import cn.hutool.Hutool;
import cn.hutool.core.convert.Convert;
import com.google.common.base.CaseFormat;
import org.junit.Test;

/**
 * @author zetu
 * @date 2021/5/8
 */
public class UnderscoreCamelTest {

    /**
     * 下划线与驼峰命名的相互转换
     */
    @Test
    public void underscoreCamelTest() {
        // testData
        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));
        // testData
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));
        // TestData
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));

        // testdata
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "testdata"));
        // test_data
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "TestData"));
        // test-data
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN, "testData"));
    }
}
