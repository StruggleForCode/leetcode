package org.leetcode;

import org.junit.jupiter.api.Test;

/**
 * ClassName: LeetCode66
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/4/4 18:21
 * @Version 1.0
 */
public class LeetCode66 {

    @Test
    public void test() {
        int[] digits = {9};
        plusOne(digits);
    }

    public int[] plusOne(int[] digits) {
        int right = digits.length - 1;
        digits[right] += 1;
        while (right > 0 && digits[right] == 10) {
            digits[right--] = 0;
            if (right >= 0)
                digits[right] += 1;
        }
        if (digits[0] >= 10) {
            digits[0] = 0;
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 1; i < newDigits.length; i++) {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        } else {
            return digits;
        }
    }
}
