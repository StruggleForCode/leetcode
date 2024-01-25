package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LeetCode12
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/1/25 23:17
 * @Version 1.0
 */
public class LeetCode12 {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(58));
    }

    public static String intToRoman(int num) {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1000, "M");
        hashMap.put(900, "CM");
        hashMap.put(500, "D");
        hashMap.put(400, "CD");
        hashMap.put(100, "C");
        hashMap.put(90, "XC");
        hashMap.put(50, "L");
        hashMap.put(40, "XL");
        hashMap.put(10, "X");
        hashMap.put(9, "IX");
        hashMap.put(5, "V");
        hashMap.put(4, "IV");
        hashMap.put(1, "I");
        String res = "";
        while(num >= 1000) {
            num -= 1000;
            res += hashMap.get(1000);
        }
        while (num >= 900) {
            num -= 900;
            res += hashMap.get(900);
        }
        while (num >= 500) {
            num -= 500;
            res += hashMap.get(500);
        }
        while (num >= 400) {
            num -= 400;
            res += hashMap.get(400);
        }
        while (num >= 100) {
            num -= 100;
            res += hashMap.get(100);
        }
        while (num >= 90) {
            num -= 90;
            res += hashMap.get(90);
        }
        while (num >= 50) {
            num -= 50;
            res += hashMap.get(50);
        }
        while (num >= 40) {
            num -= 40;
            res += hashMap.get(40);
        }
        while (num >= 10) {
            num -= 10;
            res += hashMap.get(10);
        }
        while (num >= 9) {
            num -= 9;
            res += hashMap.get(9);
        }
        while (num >= 5) {
            num -= 5;
            res += hashMap.get(5);
        }
        while (num >= 4) {
            num -= 4;
            res += hashMap.get(4);
        }
        while (num >= 1) {
            num -= 1;
            res += hashMap.get(1);
        }
        return res;
    }
}
