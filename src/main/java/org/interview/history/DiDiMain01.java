package org.interview.history;

import java.util.Scanner;

/**
 * ClassName: Main
 * Package: org.interview.current
 * Description: didi笔试第一题
 *
 * @Author LeeHao
 * @Create 2024/9/13 19:40
 * @Version 1.0
 */
public class DiDiMain01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int left = 0;
        int right = 1;
        int curNum = 1;
        int res = 1;
        m -= a[0];
        while (right < n && left <= right) {
            if (m <= 0) {
                curNum--;
                m += a[left];
                left++;
                continue;
            }
            m -= a[right];
            right++;
            curNum++;
            if (res < curNum && m >= 0) {
                res = curNum;
            }
        }
        System.out.println(res);
    }
}

/*
5 5
1 4 2 2 1

5 2
1 4 2 2 1
 */

