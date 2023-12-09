package org.leetcode;

import sun.rmi.runtime.Log;

import java.util.*;

public class LeetCodeOffer49 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1407));
    }
    public static int nthUglyNumber(int n) {
        Set<Long> set = new TreeSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.offer(1L);
        set.add(1L);
        int count = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            long cur = queue.poll();
            count++;
            if (count == n) {
                result = (int) cur;
            }
            Long one = cur * 2;
            Long tow = cur * 3;
            Long three = cur * 5;
            if (!set.contains(one)) {
                set.add(one);
                queue.offer(one);
            }
            if (!set.contains(tow)) {
                set.add(tow);
                queue.offer(tow);
            }
            if (!set.contains(three)) {
                set.add(three);
                queue.offer(three);
            }
        }
        return result;
    }
}
