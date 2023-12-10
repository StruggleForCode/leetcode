package org.leetcode;

/**
 * ClassName: LeetCode122
 * Package: org.leetcode
 * Description: 买卖股票的最佳时机 II
 *
 * @Author LeeHao
 * @Create 2023/12/9 12:13
 * @Version 1.0
 */
public class LeetCode122 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minValue = prices[0];
        boolean flag = true;
        for (int i = 0; i < prices.length - 1; i++) {
            // 卖出
            if (prices[i] > prices[i+1] && flag) {
                max += (prices[i] - minValue);
                minValue = prices[i + 1];
                flag = false;
            }
            // 买入
            if (prices[i] < prices[i + 1] && !flag) {

            }
        }
        return max;
    }
}

/*
维护一个bool ，是否购入，如果后一个值比前一个值大就购入，否则就不购入
同时维护一个最小值

维护一个数组
7,1,5,3,6,4

7,1,5,3,10,1,8,1,9,3,6,4

7 1 5 3 10 1 8 1 9 3 6 4

8 + 7 +

4 + 7 = 11

1 2 4 5 6 7 8

7 4 3 2 1
 */