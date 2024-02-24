package org.leetcode;

/**
 * ClassName: LeetCode130
 * Package: org.leetcode
 * Description: 击败99.7的用户
 *
 * @Author LeeHao
 * @Create 2024/2/24 13:48
 * @Version 1.0
 */
public class LeetCode130 {

    /**
     * 换个思路，先找到与边界上'O'相连的'O',标记之后，统一遍历board, 把为'0',且没有标记的'0'置为X
     * @param board
     */
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] flag = new boolean[n][m];
        for (int i = 0; i < n; i++)  {
            for (int j = 0; j < m; j++) {
                flag[i][j] = false;
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                dfs(board, flag, i, 0);
            }
            if (board[i][m - 1] == 'O') {
                dfs(board, flag, i, m - 1);
            }
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                dfs(board, flag, 0, j);
            }
            if (board[n - 1][j] == 'O') {
                dfs(board, flag, n - 1, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O' && !flag[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs (char[][] board, boolean[][] flag, int cow, int line) {
        int n = board.length;
        int m = board[0].length;
        if (cow >= n || line >= m || cow < 0 || line < 0 || board[cow][line] != 'O' || flag[cow][line]) {
            return;
        }
        flag[cow][line] = true;
        dfs(board, flag, cow + 1, line);
        dfs(board, flag, cow - 1, line);
        dfs(board, flag, cow, line - 1);
        dfs(board, flag, cow, line + 1);
    }
}
