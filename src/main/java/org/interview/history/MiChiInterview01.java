package org.interview.history;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 幂律科技面试
 */
public class MiChiInterview01 {
    // 已知数组 A, B, 如果 A 中元素在 B 数组存在，打印出这个元素的下标，B 数组是不重复的.
    // Input: [5, 3, 1, 5, 4] [5, 3]
    // Output: [0, 1, 3]
        public static void main(String[] args) {
            int[] a = new int[]{5, 3, 1, 5, 4};
            int[] b = new int[]{5, 3};

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < b.length; i++) {
                set.add(b[i]);
            }

            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < a.length; i++) {
                if (set.contains(a[i])) {
                    result.add(i);
                }
            }

            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + " ");
            }

        }
}