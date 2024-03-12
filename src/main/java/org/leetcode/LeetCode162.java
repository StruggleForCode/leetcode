package org.leetcode;

import org.junit.jupiter.api.Test;

/**
 * ClassName: LeetCode162
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/5 23:10
 * @Version 1.0
 */
public class LeetCode162 {

   @Test
   public void test() {
       int[] nums = {1, 3, 2, 1};
       System.out.println(findPeakElement2(nums));
   }

   // 一直过不了
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length;
        if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (mid == 0 || mid == nums.length - 1) return mid;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            if (nums[mid] > nums[mid + 1]) right = mid - 1;
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
        }
        return 0;
    }

    /*
    爬坡法：
    也许很多人看了，还是不懂，图解也只是迷迷糊糊根据答案来，
    我这里通俗解释以下，这道题，最最最重要的是条件，条件，条件，两边都是负无穷，数组当中可能有很多波峰，也可能只有一个，
    如果尝试画图，就跟股票信息一样，没有规律，如果根据中点値判断我们的二分方向该往何处取， 这道题还有只是返回一个波峰。
    你这样想，中点所在地方，可能是某座山的山峰，山的下坡处，山的上坡处，如果是山峰，最后会二分终止也会找到，关键是我们的二分方向，
    并不知道山峰在我们左边还是右边，送你两个字你就明白了，爬山（没错，就是带你去爬山），
    如果你往下坡方向走，也许可能遇到新的山峰，但是也许是一个一直下降的坡，最后到边界。
    但是如果你往上坡方向走，就算最后一直上的边界，由于最边界是负无穷，所以就一定能找到山峰，
    总的一句话，往递增的方向上，二分，一定能找到，往递减的方向只是可能找到，也许没有。
     */
    public int findPeakElement2(int[] nums) {
       int left = 0;
       int right = nums.length - 1;
       while (left < right) {
           int mid = (right - left) / 2 + left;
           if (nums[mid] < nums[mid + 1]) {
               left = mid + 1;
           } else {
               right = mid;
           }
       }
       return left;
    }


}
