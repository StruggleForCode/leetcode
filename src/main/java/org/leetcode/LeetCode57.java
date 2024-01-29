package org.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: LeetCode57
 * Package: org.leetcode
 * Description: 插入区间 中等。
 * 采用了笨方法的模拟，把所有情况都列举了，题解好像有简单方法。
 *
 * @Author LeeHao
 * @Create 2024/1/29 23:27
 * @Version 1.0
 */
public class LeetCode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new LinkedList<>();
        if (intervals.length == 0) {
            int[][] ans = new int[1][2];
            ans[0][0] = newInterval[0];
            ans[0][1] = newInterval[1];
            return ans;
        }
        for (int i = 0; i < intervals.length; i++){
            int[] tmp = new int[2];
            tmp[0] = intervals[i][0];
            tmp[1] = intervals[i][1];
            list.add(tmp);
        }
        int lastRight = list.get(0)[1];
        int i = 0;
        for ( ; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (newInterval[0] < left) {
                insertTo(i, list, newInterval, newInterval[0], right);
                break;
            }
            if (newInterval[0] > right) {
                continue;
            }
            if (newInterval[0] >= left && newInterval[1] <= right) {
                break;
            }
            if (newInterval[0] >= lastRight && newInterval[1] <= right) {
                list.add(i, newInterval);
            }
            if ((newInterval[0] >= left && newInterval[1] > right)) {
                insertTo(i, list, newInterval, left, right);
                break;
            }
        }
        if (i == intervals.length) {
            list.add(i, newInterval);
        }
        int[][] ans = new int[list.size()][2];
        for (int j = 0; j < list.size(); j++) {
            ans[j][0] = list.get(j)[0];
            ans[j][1] = list.get(j)[1];
        }
        return ans;
    }

    public void insertTo(int i, List<int[]> list, int[] newInterval, int left, int right) {
        while (i < list.size()) {
            if (newInterval[1] > list.get(i)[1]) {
                list.remove(i);
                continue;
            }
            if (newInterval[1] < list.get(i)[0]) {
                list.add(i, new int[] {left, newInterval[1]});
                break;
            }
            if (newInterval[1] >= list.get(i)[0] && newInterval[1] <= list.get(i)[1]) {
                right = list.get(i)[1];
                list.remove(i);
                list.add(i, new int[] {left, right});
                break;
            }
        }
        if (list.size() == 0) {
            list.add(i, new int[] {left, newInterval[1]});
            return;
        }
        if (list.get(list.size() - 1)[1] < newInterval[1]) {
            list.add(i, new int[] {left, newInterval[1]});
        }
    }
}
