package org.leetcode;

import java.util.*;

/**
 * ClassName: LeetCode30
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2023/12/22 20:28
 * @Version 1.0
 */
public class LeetCode30 {
    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar","foo","the"};
        String s2 = "barfoothefoobarman";
        String[] words2 = {"bar","foo"};
        List<Integer> substring = findSubstring(s, words);
        System.out.println(substring);

    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0 || s.length() == 0) {
            return res;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String key = words[i];
            if (map.containsKey(key)) {
                int value = map.get(key);
                map.put(key, value + 1);
            }
            map.put(key, 1);
        }

        for (int i = 0; i < words[0].length(); i++) {
            function(s, words, map, res, i, i);
        }

        return res;
    }

    public static void function(String s, String[] words, Map<String, Integer> map, List<Integer> res, int left, int right){
        int width = words[0].length();
        int size = words.length;
        while (right < s.length()) {
            if (size == 0) {
                res.add(left);
                String keyTemp = s.substring(left, left + width);
                if (map.containsKey(keyTemp)) {
                    int valueTemp = map.get(keyTemp);
                    map.put(keyTemp, valueTemp + 1);
                    size++;
                }
                left += width;
            }
            if (right + width > s.length()) break;
            String tmp = s.substring(right, right + width);
            if (map.containsKey(tmp) && map.get(tmp) > 0) {
                int value = map.get(tmp);
                map.put(tmp, value - 1);
                right += width;
                size--;
            } else {
                while (left <= right) {
                    if (size >= words.length) {
                        break;
                    }
                    String keyTemp = s.substring(left, left + width);
                    if (map.containsKey(keyTemp)) {
                        int valueTemp = map.get(keyTemp);
                        map.put(keyTemp, valueTemp + 1);
                        size++;
                    }
                    left += width;
                }
                if (size >= words.length) {
                    continue;
                }
                right += width;
            }
        }
    }
}

/*
barfoofoobarthefoobarman
 */