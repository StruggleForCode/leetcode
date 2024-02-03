package org.leetcode;

/**
 * ClassName: LeetCode14
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/3 20:51
 * @Version 1.0
 */
public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        String ret = "";
        int index = 0;
        while (index < strs[0].length()) {
            char ch = strs[0].charAt(index);
            int i;
            for (i = 0; i < strs.length; i++) {
                if (strs[i].length() <= index || strs[i].charAt(index) != ch) {
                    break;
                }
            }
            if (i != strs.length) {
                break;
            } else {
                ret += ch;
            }
            index++;
        }
        return ret;
    }
}
