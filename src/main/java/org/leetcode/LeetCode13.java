package org.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * ClassName: LeetCode13
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/1/25 22:56
 * @Version 1.0
 */
public class LeetCode13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("LVIII"));
    }
    public static int romanToInt(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        int res = 0;
        int i = 0;
        for (; i < s.length() - 1; i++) {
            char cur = s.charAt(i);
            char next = s.charAt(i + 1);
            int curVal = hashMap.get(cur);
            int nextVal = hashMap.get(next);
            if (nextVal > curVal) {
                res += (nextVal - curVal);
                i++;
                continue;
            }
            res += curVal;
        }
        if (i == s.length()) {
            return res;
        }
        res += hashMap.get(s.charAt(i));
        return res;
    }

}
