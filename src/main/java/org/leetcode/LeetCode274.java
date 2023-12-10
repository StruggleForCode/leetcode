package org.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ClassName: LeetCode46
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2023/12/9 15:30
 * @Version 1.0
 */
public class LeetCode274 {
    public static void main(String[] args) {
        int[] citations = {1, 7, 9, 4};
        System.out.println(hIndex(citations));
    }
    public static int hIndex1(int[] citations) {
        Arrays.sort(citations);
        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] != 0) {
                arrayList.add(citations[i]);
            }
        }
        if (arrayList.size() == 0) {
            return 0;
        }
        int maxH = Math.min(arrayList.get(0), arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.size() - i >= arrayList.get(i)) {
                maxH = arrayList.get(i);
            }
        }
        return maxH;
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }
}


// [3,0,6,1,5]
// 0 1 3 5 6

// 0, 0, 0, 2, 4, 7, 9

// 0, 0, 0, 1, 2, 2, 3

// 2 4 7 6
// 1 2 2 3