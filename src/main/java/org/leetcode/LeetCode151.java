package org.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: LeetCode151
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/1/26 21:14
 * @Version 1.0
 */
public class LeetCode151 {
    public static void main(String[] args) {
        String s = "  Hello    World   ni  hao  ";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        s = s.trim();
        //System.out.println(s + "*");
        String tmp = "";
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (tmp.length() != 0)
                    arrayList.add(tmp);
                tmp = "";
                continue;
            }
            tmp += s.charAt(i);
        }
        arrayList.add(tmp);
        String ret = "";
        ret = arrayList.get(arrayList.size() - 1);
        for (int i = arrayList.size() - 2; i >= 0; i--) {
            ret += " ";
            ret += arrayList.get(i);
        }
        return ret;
    }

    // 官方解法
    public String reverseWords2(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
