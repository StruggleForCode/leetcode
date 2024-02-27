package org.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: LeetCode210
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/28 00:12
 * @Version 1.0
 */
public class LeetCode210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 记录边
        int [][] map = new int[numCourses][numCourses];
        // 记录前缀
        int[] prefix = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            prefix[i] = 0;
            for (int j = 0; j < numCourses; j++) {
                map[i][j] = 0;
            }
        }
        // 初始化， i,j=1 表示， 从i到j有一条边，学习j,之前必须学习i;
        for (int i = 0; i < prerequisites.length; i++) {
            map[prerequisites[i][1]][prerequisites[i][0]] = 1;
            prefix[prerequisites[i][0]]++;
        }
        // 用于记录无前缀的节点，
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (prefix[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            res[index++] = curCourse;
            for (int i = 0; i < numCourses; i++) {
                if (map[curCourse][i] == 1) {
                    prefix[i]--;
                    if (prefix[i] == 0) queue.offer(i);
                    else if (prefix[i] < 0) break;
                }
            }
        }
        if (index < numCourses) return new int[0];
        else return res;
    }
}
