package org.leetcode;

/**
 * ClassName: LeetCode28
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/3 16:14
 * @Version 1.0
 */
public class LeetCode28 {
    public int strStr(String haystack, String needle) {
        int res = -1;
        int index = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.startsWith(needle, i)) {
                res = i;
                break;
            }
        }
        return res;
    }
}
