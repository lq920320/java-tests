package leetcode;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2020/11/1 13:49
 */
public class IntegerToRoman {


    @Test
    public void int2RomanTest() {
        System.out.println(intToRoman(2));
        System.out.println(intToRoman(13));
        System.out.println(intToRoman(5));
    }


    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;

        StringBuilder result = new StringBuilder();
        while (index < 13) {
            if (num >= nums[index]) {
                result.append(romans[index]);
                num -= nums[index];
            } else {
                index++;
            }
        }

        return result.toString();
    }
}
