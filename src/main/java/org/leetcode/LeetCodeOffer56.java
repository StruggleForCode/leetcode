package org.leetcode;

public class LeetCodeOffer56 {
    public static void main(String[] args) {
        System.out.println(10|8);
        int[] nums = {1,3,11,4,1,4,3,3};
        //System.out.println(2^10);
        int[] res = singleNumbers(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    public static int[] singleNumbers(int[] nums) {
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x ^= nums[i];
        }
        int tmp = x;
        int cnt = 1;
        while(tmp % 2 == 0){
            cnt <<= 1;
            tmp >>= 1;
        }
        //System.out.println(cnt);
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; i++){
            if((nums[i] | cnt) == nums[i]){
                num1 ^= nums[i];
            } else {
                num2 ^= nums[i];
            }
        }
        int[] res = new int[2];
        res[0] = num1;
        res[1] = num2;
        return res;
    }
}
/*
2  00000010
10 00001010
8  00001000

00000011

 */
