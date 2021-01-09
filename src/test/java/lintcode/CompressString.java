package lintcode;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2021/1/9 16:00
 */
public class CompressString {

    @Test
    public void compressStringTest() {
        String a = "aabbbccc";
        String b = "aabbcc";

        System.out.println(a);
        System.out.println(solution2(a));

        System.out.println(b);
        System.out.println(solution2(b));
    }

    /**
     * 双指针解法
     *
     * @param str
     * @return
     */
    public String solution2(String str) {
        if (str == null || str.length() <= 2) {
            return str;
        }
        StringBuilder result = new StringBuilder();
        int start = 0;
        int end = 1;
        int len = str.length();
        while (end < len) {
            while (end < len && str.charAt(end) == str.charAt(end - 1)) {
                end++;
            }
            result.append(str.charAt(start)).append((end - start));
            start = end;
            end++;
        }

        String res = result.toString();

        return res.length() < len ? res : str;
    }
}
