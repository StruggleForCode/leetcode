package org.leetcode;

/**
 * ClassName: LeetCode202
 * Package: org.leetcode
 * Description: 快乐数
 *
 * @Author LeeHao
 * @Create 2024/1/27 21:28
 * @Version 1.0
 */
public class LeetCode202 {
    public static void main(String[] args) {

    }

    /**
     * 需要再做，自己用暴力解出来的，不符合题目考点
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        for (int i = 0 ; i < 100; i++) {
            n = squares(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    public int squares(int num) {
        int sum = 0;
        while (num >0) {
            int cur = num % 10;
            sum += cur * cur;
            num /= 10;
        }
        return sum;
    }
}
