package org.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LeetCode219
 * Package: org.leetcode
 * Description: 219. 存在重复元素 II
 *
 * @Author LeeHao
 * @Create 2024/1/28 18:54
 * @Version 1.0
 */
public class LeetCode219 {
    public static void main(String[] args) {

    }

    /**
     * 方法有点笨，只需判断第二个就可以了
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (hashMap.containsKey(cur)) {
                ArrayList<Integer> list = hashMap.get(cur);
                for (int l : list) {
                    if (Math.abs(l - i) <= k) {
                        return true;
                    }
                }
                list.add(i);
                hashMap.put(cur, list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(cur, list);
            }
        }
        return false;
    }
}
