package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LeetCode146
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/5 20:21
 * @Version 1.0
 */
public class LeetCode146 {
    private int capacity = 0;
    private Map<Integer, Integer> saveMap;
    private int size = 0;
    public LeetCode146(int capacity) {
        this.capacity = capacity;
        saveMap = new HashMap<>();
    }

    public int get(int key) {
        if (!saveMap.containsKey(key)) {
            return -1;
        }


        return saveMap.get(key);
    }

    public void put(int key, int value) {
//        if (this.size == this.capacity) {
//            saveMap.remove();
//        }
    }
}
