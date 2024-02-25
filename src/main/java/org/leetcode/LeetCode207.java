package org.leetcode;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: LeetCode207
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/25 23:06
 * @Version 1.0
 */
public class LeetCode207 {

    @Test
    public void test() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        boolean res =canFinish(numCourses, prerequisites);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            for (int i = 0; i < numCourses; i++) {
                if (map[curCourse][i] == 1) {
                    prefix[i]--;
                    if (prefix[i] == 0) queue.offer(i);
                    else if (prefix[i] < 0) return false;
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (prefix[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
