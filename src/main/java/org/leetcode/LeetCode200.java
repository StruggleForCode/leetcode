package org.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: LeetCode200
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/24 12:33
 * @Version 1.0
 */
public class LeetCode200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    /**
     * bfs
     * @param grid
     * @param cow
     * @param line
     */
    public void bfs(char[][] grid, int cow, int line) {
        int[][] step = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int n = grid.length; // 行
        int m = grid[0].length; // 列
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {cow, line});
        grid[cow][line] = '0';
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curCow = cur[0];
            int curLine = cur[1];
            grid[curCow][curLine] = '0';
            for (int i = 0; i < step.length; i++) {
                int nextCow = curCow + step[i][0];
                int nextLine = curLine + step[i][1];
                if (nextLine < m && nextLine >= 0 && nextCow < n && nextCow >= 0 && grid[nextCow][nextLine] == '1') {
                    grid[nextCow][nextLine] = '0';
                    queue.offer(new int[] {nextCow, nextLine});
                }
            }
        }
    }

    /**
     * dfs
     * @param grid
     * @param cow
     * @param line
     */
    public void dfs(char[][] grid, int cow, int line) {
        int n = grid.length; // 行
        int m = grid[0].length; // 列
        if (cow >= n || cow < 0 || line >= m || line < 0 || grid[cow][line] != '1') {
            return;
        }
        grid[cow][line] = '0';
        dfs(grid, cow + 1, line);
        dfs(grid, cow - 1, line);
        dfs(grid, cow, line + 1);
        dfs(grid, cow, line - 1);
    }
}
