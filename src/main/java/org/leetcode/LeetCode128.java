package org.leetcode;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * ClassName: LeetCode128
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/1/28 17:58
 * @Version 1.0
 */
public class LeetCode128 {
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }

    /**
     * O(N)时间复杂度内解决此问题。
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            treeSet.add(nums[i]);
        }
        Iterator<Integer> it = treeSet.iterator();
        it.hasNext();
        int last = it.next();
        int size = 1;
        int maxSize = size;
        while (it.hasNext()) {
            int next = it.next();
            if (next - last == 1) {
                size++;
            } else {
                maxSize = Math.max(maxSize, size);
                size = 1;
            }
            last = next;
        }
        maxSize = Math.max(maxSize, size);
        return maxSize;
    }
}
