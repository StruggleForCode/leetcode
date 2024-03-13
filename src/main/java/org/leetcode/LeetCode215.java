package org.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ClassName: LeetCode215
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/13 22:36
 * @Version 1.0
 */
public class LeetCode215 {
    @Test
    public void test() {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparing(a -> a));
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
