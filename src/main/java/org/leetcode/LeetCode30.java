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
        String s3 = "wordgoodgoodgoodbestword";
        String[] words3 = {"word","good","best","word"};
        String s4 = "wordgoodgoodgoodbestword";
        String[] words4 = {"word","good","best","good"};
        String s5 = "aaaaaaaaaaaaaa";
        String[] words5 = {"aa","aa"};
        List<Integer> substring = findSubstring(s5, words5);
        System.out.println(substring);

    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0 || s.length() == 0) {
            return res;
        }
        for (int i = 0; i < words[0].length(); i++) {
            function(s, words, res, i, i);
        }
        return res;
    }

    public static void function(String s, String[] words, List<Integer> res, int left, int right){
        // 存到map中
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String key = words[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int width = words[0].length();
        // size 用于记录 map中的值是否取完
        int size = words.length;
        while (right <= s.length()) {
            if (size == 0) {
                res.add(left);
            }
            if (right + width > s.length()) break;
            String tmp = s.substring(right, right + width);
            if (map.containsKey(tmp) && map.get(tmp) > 0) {
                int value = map.get(tmp);
                map.put(tmp, value - 1);
                right += width;
                size--;
            } else {
                String keyTemp = s.substring(left, left + width);
                if (map.containsKey(keyTemp)) {
                    int valueTemp = map.get(keyTemp);
                    map.put(keyTemp, valueTemp + 1);
                    size++;
                    left += width;
                } else {
                    // 这一个判断有一点点绕
                    left += width;
                    right += width;
                }
            }
        }
    }
}

/*
bar foo foo bar the foo bar man

"bar","foo","the"
 */