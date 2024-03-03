package org.leetcode;

import org.junit.jupiter.api.Test;

/**
 * ClassName: LeetCode79
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/3 13:05
 * @Version 1.0
 */
public class LeetCode79 {

    @Test
    public void test() {
       char[][] board =  {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
       String word = "ABCB";
        System.out.println(exist(board, word));
    }


    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    used[i][j] = true;
                    if(dfs(board, i, j, word, used, 1)) {
                        return true;
                    }
                    used[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int cow, int line, String word, boolean[][] used, int index) {
        if (index == word.length()) {
            return true;
        }
        int n = board.length;
        int m = board[0].length;
        int[][] step = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < 4; i++) {
            int nextCow = cow + step[i][0];
            int nextLine = line + step[i][1];
            if (nextCow >= 0 && nextCow < n && nextLine >=0 && nextLine < m &&
                    !used[nextCow][nextLine] && board[nextCow][nextLine] == word.charAt(index)) {
                used[nextCow][nextLine] = true;
                boolean ok = dfs(board, nextCow, nextLine, word, used, index + 1);
                if (ok) return true;
                used[nextCow][nextLine] = false;
            }
        }
        return false;
    }

}
