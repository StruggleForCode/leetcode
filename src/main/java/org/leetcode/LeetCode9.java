package org.leetcode;

/**
 * ClassName: LeetCode9
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/4/4 18:16
 * @Version 1.0
 */
public class LeetCode9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
