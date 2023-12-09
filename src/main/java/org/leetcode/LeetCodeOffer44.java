package org.leetcode;

public class LeetCodeOffer44 {
    public static void main(String[] args) {
        System.out.println(findNthDigit(1000000000));
    }
    public static int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int count = 1;
        n = n - 10;
        int tmp = n;
        while (tmp >= 0) {
            n = tmp;
            count++;
            long sub = 9;
            for (int i = 1; i < count; i++) {
                sub *= 10;
            }
            sub *= count;
            if (tmp < sub) break;
            tmp -= sub;
        }
        tmp = n / count;
        int mod = n % count;
        int start = (int) Math.pow(10, count - 1);
        long num = (long)start + (long)tmp;
        //System.out.println(num);
        String str = String.valueOf(num);
        char[] ch = str.toCharArray();
        //if (mod != 0) mod -= 1;
        int res = ch[mod] - '0';
        return res;
    }
}
/*
10
90 * 2
900 * 3
9000 * 4
90000 * 5

1002
190
1000 - 10 - 90 * 2 = 812
812 / 3 = 270 812 % 3 = 2;
100 + 270 - 1= 369 371
10 + 180 + 270 * 3 +



 */
