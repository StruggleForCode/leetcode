package org.leetcode;

import org.junit.jupiter.api.Test;

/**
 * ClassName: LeetCode198
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/4/6 14:57
 * @Version 1.0
 */
public class LeetCode198 {

    @Test
    public void test() {
        int[] nums = {2, 1, 1, 2};
        int[] nums2 = {2,7,9,3,1};
        int[] nums3 = {0};
        System.out.println(rob3(nums3));
    }

    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int lastNum = nums[nums.length - 1];
        for (int i = 2; i < nums.length; i++) {
            nums[i] = nums[i - 2] + nums[i];
        }
        int res = Math.max(nums[nums.length - 1], nums[nums.length - 2]);
        if (nums.length % 2 == 0) {
            res = Math.max(res, nums[0] + lastNum);
        }
        return res;
    }

    public int rob2(int[] nums) {
        boolean[] visit = new boolean[nums.length];
        int[] moneyMax = new int[nums.length];
        moneyMax[0] = nums[0];
        visit[0] =true;
        if (nums[1] > nums[0]) {
            moneyMax[1] = nums[1];
            visit[1] = true;
            visit[0] = false;
        } else {
            moneyMax[1] = nums[0];
            visit[1] = false;
        }
        for (int i = 2; i < nums.length; i++) {
            // n - 1 房间抢了
            if (visit[i - 1]) {
                // 假设不n-1 房屋，抢本次这个房屋的收益, 为什么加nums[i - 2]？ 如果不强 n - 1 一定抢 n -2
                int tempMoney = moneyMax[i - 1] - nums[i - 1] + nums[i - 2] + nums[i];
                if (moneyMax[i - 1] < tempMoney) {
                    //抢了收益高
                    moneyMax[i] = tempMoney;
                    visit[i] = true;
                    //visit[i - 1] = false;
                } else {
                    // 不抢，其实也不用设置，默认false;
                    moneyMax[i] = moneyMax[i - 1];
                    visit[i] = false;
                }
            } else  {
                //n-1房间没有抢（一定是抢的第n-2个），第n个房屋一定抢，收益是最高的
                moneyMax[i] = moneyMax[i - 1] + nums[i];
                visit[i] = true;
            }
        }
        return moneyMax[nums.length - 1];
    }

    public int rob3(int[] nums) {
        boolean[] visit = new boolean[nums.length];
        int[] moneyMax = new int[nums.length];
        moneyMax[0] = nums[0];
        visit[0] =true;
        if (nums.length < 2) {
            return nums[0];
        }
        if (nums[1] > nums[0]) {
            moneyMax[1] = nums[1];
            visit[1] = true;
        } else {
            moneyMax[1] = nums[0];
            visit[1] = false;
        }
        for (int i = 2; i < nums.length; i++) {
            if (visit[i - 1]) {
                // n - 1 房间抢了
                // 假设不抢 n- 1 房屋，抢本次这个房屋的收益
                int tempMoney = moneyMax[i - 2] + nums[i];
                if (moneyMax[i - 1] < tempMoney) {
                    //抢了收益高
                    moneyMax[i] = tempMoney;
                    visit[i] = true;
                } else {
                    // 不抢，其实也不用设置，默认false;
                    moneyMax[i] = moneyMax[i - 1];
                    visit[i] = false;
                }
            } else  {
                //n-1房间没有抢（一定是抢的第n-2房间），第n个房屋一定抢，收益是最高的
                moneyMax[i] = moneyMax[i - 1] + nums[i];
                visit[i] = true;
            }
        }
        return moneyMax[nums.length - 1];
    }
}


/*


1 10000 2 3  100 3 2

对于当前房屋，抢？还是不抢？
抢的话，前一个房屋不能抢，
表示有n个房屋, 小偷获得的最大利益是多少

假设抢了n个房屋的最大收益为moneyMax[n]

对于对n+1个房屋，是否可以抢，有两种判断：

1.如果已知抢了n个房屋的最大收益moneyMax[n] 包含抢了第n个房屋，
  此时，对于第n+1个房屋是是否可以抢到 最大收益为moneyMax[n+1]= max{moneyMax[n]-num[n] + num[n+1], moneyMax[n]}

  moneyMax[n] =

2. 如果已知抢了n个房屋的最大收益moneyMax[n] 不包含抢了第n个房屋，
    moneyMax[n+1] = moneyMax[n] + num[n+1]

对于第n个房间是否抢了，收益最大，可以用visit[i]表示。

初始值

moneyMax[0] = num[0];  vist[0] = true;

moneyMax[1] = money[0] - num[0] + num[1], m

如果有n+1个房屋。
小偷是否能抢改房屋，有两种条件
1. 抢了第n个房屋， moneyMax[n] = max(mon

moneyMax[n+1] =

抢当前房屋就不能抢前一个房屋。


visit数组表示



 */
