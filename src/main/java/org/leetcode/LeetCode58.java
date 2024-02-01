package org.leetcode;

/**
 * ClassName: LeetCode58
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/1 21:43
 * @Version 1.0
 */
public class LeetCode58 {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] strs = s.split(" ");
        return strs[strs.length - 1].length();
    }
}
