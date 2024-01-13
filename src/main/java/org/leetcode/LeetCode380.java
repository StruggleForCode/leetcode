package org.leetcode;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * ClassName: LeetCode380
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/1/13 13:41
 * @Version 1.0
 */
public class LeetCode380 {
}

class RandomizedSet {
    private Set<Integer> hashSet;
    private int count;

    public RandomizedSet() {
        hashSet = new HashSet<>();
        count = 0;
    }

    public boolean insert(int val) {
        if (hashSet.contains(val)) {
            return false;
        }
        hashSet.add(val);
        count++;
        return true;
    }

    public boolean remove(int val) {
        if (!hashSet.contains(val)) {
            return false;
        }
        hashSet.remove(val);
        count--;
        return true;
    }

    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(count);
        Object[] array = hashSet.toArray();
        return (int) array[index];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

/*
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[],               [1],      [2],       [2],     [],          [1],      [2],      []]
[null,             true,     false,     true,    2,           true,     false,    2]

 */
