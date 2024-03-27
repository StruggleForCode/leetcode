package org.leetcode;

import org.junit.jupiter.api.Test;

/**
 * ClassName: LeetCode67
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/27 21:58
 * @Version 1.0
 */
public class LeetCode67 {
    public String addBinary(String a, String b) {
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        int next = 0;
        String res = "";
        while (lenA >= 0 && lenB >=0) {
            char curA = a.charAt(lenA);
            char curB = b.charAt(lenB);
            int cur = curA - '0' + curB - '0' + next;
            if (cur == 0 || cur == 1) {
                res = (char) (cur + '0') + res;
                next = 0;
            } else if (cur == 2) {
                res = "0" + res;
                next = 1;
            } else if (cur == 3) {
                res = "1" + res;
                next = 1;
            }
            lenA--;
            lenB--;
        }
        while (lenA >= 0) {
            char curA = a.charAt(lenA);
            int cur = curA - '0' + next;
            if (cur == 0 || cur == 1) {
                res = (char) (cur + '0') + res;
                next = 0;
            } else if (cur == 2) {
                res = "0" + res;
                next = 1;
            } else if (cur == 3) {
                res = "1" + res;
                next = 1;
            }
            lenA--;
        }
        while (lenB >= 0) {
            char curB = b.charAt(lenB);
            int cur = curB - '0' + next;
            if (cur == 0 || cur == 1) {
                res = (char) (cur + '0') + res;
                next = 0;
            } else if (cur == 2) {
                res = "0" + res;
                next = 1;
            } else if (cur == 3) {
                res = "1" + res;
                next = 1;
            }
            lenB--;
        }
        if (next == 1) {
            res = "1" + res;
        }
        return res;
    }


    public String addBinary2(String a, String b) {
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        String res = "";
        while (lenA >= 0 && lenB >= 0) {
            char curA = a.charAt(lenA);
            char curB = b.charAt(lenB);
            int cur = curA - '0' + curB - '0';
            res = (char) (cur + '0') + res;
            lenA--;
            lenB--;
        }
        while (lenA >= 0) {
            res = a.charAt(lenA) + res;
            lenA--;
        }
        while (lenB >= 0) {
            res = b.charAt(lenB) + res;
            lenB--;
        }
        int next = 0;
        String ans = "";
        for (int i = res.length() - 1; i >= 0; i--) {
            int cur = res.charAt(i) - '0' + next;
            if (cur == 0) {
                ans = "0" + ans;
                next = 0;
            } else if (cur == 1) {
                ans = "1" + ans;
                next = 0;
            } else if (cur == 2) {
                ans = "0" + ans;
                next = 1;
            } else if (cur == 3) {
                ans = "1" + ans;
                next = 1;
            }
        }
        if (next == 1) {
            ans = "1" + ans;
        }
        return ans;
    }
    @Test
    void test() {
        String a = "11010";
        String b = "1011";
        System.out.println(addBinary2(a, b));
    }
}

/*
给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。

示例 1：
输入:a = "11", b = "1"
输出："100"
示例 2：

输入：a = "1010", b = "1011"
输出："10101"


提示：
1 <= a.length, b.length <= 104
a 和 b 仅由字符 '0' 或 '1' 组成
字符串如果不是 "0" ，就不含前导零
 */
