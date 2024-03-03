package org.leetcode;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;

/**
 * ClassName: LeetCode125
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/3 16:27
 * @Version 1.0
 */
public class LeetCode125 {

    @Test
    public void test() {
        System.out.println('A' - 'a');
        boolean palindrome = isPalindrome("a.");
        System.out.println(palindrome);
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (right > left && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
