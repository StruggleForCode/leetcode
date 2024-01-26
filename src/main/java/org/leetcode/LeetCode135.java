package org.leetcode;

/**
 * ClassName: LeetCode135
 * Package: org.leetcode
 * Description: 135. 分发糖果
 * 一开始没做出来，后来看了解析，没看代码，写出来了，太魔幻了这题，贪心我称之为最难类型题目。
 *
 * @Author LeeHao
 * @Create 2024/1/26 19:53
 * @Version 1.0
 */
public class LeetCode135 {
    public static void main(String[] args) {
        int[] ratings = {1,2,87,87,87,2,1};
        System.out.println(candy2(ratings));
    }

    // 贪心
    // 思路： 找到数组中的每一个波谷，使其为1，如果 相等，
    // 没做出来
    public int candy(int[] ratings) {
        // 用户记录最终结果
        int[] res = new int[ratings.length];
        int ans = ratings.length;
        // 用于记录初始为1的点
        boolean[] flag = new boolean[ratings.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = 0x3f3f3f3f;
            flag[i] = false;
        }
        int firstIndex = -1;
        for (int i = 1; i < ratings.length - 1; i++) {
            // 对于某个人，<= 旁边两个人，值就为1
            if (ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1]) {
                res[i] = 1;
                flag[i] = true;
                if (firstIndex == -1) {
                    firstIndex = i;
                }
            }
        }
        // 递增或递减的情况，第一个 或者最后一个为最大 最小的。
        if (firstIndex == -1) {

        }
        return ans;
    }

    // 看了题解分析思路，没看代码，太魔幻了，都不清楚自己咋通过的。
    // 贪心真的好难（^ - ^）
    public static int candy2(int[] ratings) {
        int[] res = new int[ratings.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = 1;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                res[i] = Math.max(res[i], res[i + 1] + 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < res.length; i++) {
            ans += res[i];
        }
        return ans;
    }
}

/*
1,2,2,2,1

1 2 1 2 1

3 3 3 2 2 2 5 5 5 6 6 1 1
2 1 2 1 2 1 2 1 1 2 2 1 1

 */
