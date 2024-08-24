package org.leetcode;

/**
 * ClassName: LeetCode121
 * Package: org.leetcode
 * Description: 买卖股票的最佳时机
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150
 *
 * @Author LeeHao
 * @Create 2023/12/9 11:52
 * @Version 1.0
 */
public class LeetCode121 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = maxProfit3(prices);
        System.out.println(maxProfit);
    }

    static int maxProfit3(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            maxProfit = Math.max(prices[i] - min, maxProfit);
        }
        return maxProfit;
    }

    /**
     * 买的那天一定是卖的那天之前的最小值。 每到一天，维护那天之前的最小值即可。
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int[] minvalue = new int[prices.length];
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            minvalue[i] = Math.min(prices[i], min);
            if (prices[i] < min) {
                min = prices[i];
            }
            minvalue[i] = min;
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(prices[i] - minvalue[i], maxProfit);
        }
        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
           maxProfit = Math.max(prices[i] - min, maxProfit);
           min = Math.min(prices[i], min);
        }
        return maxProfit;
    }

}


// [7,1,5,3,6,4]
