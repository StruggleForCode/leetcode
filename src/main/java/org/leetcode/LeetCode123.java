package org.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ClassName: LeetCode123
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/8/24 15:57
 * @Version 1.0
 */
public class LeetCode123 {

    @Test
    public void test() {
        int[] prices = {3,3,5,0,0,3,1,4};
        int[] prices1 = {6,1,3,2,4,7};
        System.out.println(maxProfit(prices1));
    }

    /**
     * 这个题解之后还需要看看
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/solutions/2199035/yi-tao-mo-ban-ji-xing-dai-ma-bi-zhao-yan-0ap8
     * @param prices
     * @return
     */

    public int maxProfit(int[] prices) {
        int profits = 0;
        List<Integer> list = new ArrayList<>();
        int minPrice = prices[0];
        int maxPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int curPrice = prices[i];
            if (curPrice < minPrice) {
                list.add(maxPrice - minPrice);
                minPrice = curPrice;
                maxPrice = curPrice;
            }
            if (curPrice > maxPrice) {
                maxPrice = curPrice;
            }
        }
        list.add(maxPrice - minPrice);
        Collections.sort(list, (a, b) -> {
            return b - a;
        });
        if (list.size() >= 2) {
            profits = list.get(0) + list.get(1);
        } else {
            profits = list.get(0);
        }
        return profits;
    }
}
