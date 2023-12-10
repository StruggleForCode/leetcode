package org.leetcode;

/**
 * ClassName: LeetCode392
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2023/12/10 20:41
 * @Version 1.0
 */
public class LeetCode392 {
    public static void main(String[] args) {
        String s = "23";
        String t = "";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0 && s.length() != 0) {
            return false;
        }
        int ptrS = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(ptrS)) {
                ptrS++;
            }
            if (ptrS == s.length()) {
                return true;
            }
        }
        return false;
    }
}
/*
示例 1：
输入：s = "abc", t = "ahbgdc"
输出：true
示例 2：
输入：s = "axc", t = "ahbgdc"
输出：false

 */
