package org.leetcode;

/**
 * ClassName: LeetCode289
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2023/12/24 15:14
 * @Version 1.0
 */
public class LeetCode289 {
    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 为了优化空间，得不偿失，代码一坨，索然无趣，用了两个常量空间
     * 有点麻烦，答案简单
     * @param board
     */
    public static void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                board[i][0] = board[i][0] + (board[i][j] << j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                nextState(board, i, j, 0);
            }
        }

        int lastLineState1 = board[0][0];
        int lastLineState2;
        for (int i = 0; i < board.length; i++) {
            lastLineState2 = lastLineState1;
            lastLineState1 = board[i][0];
            nextState(board, i, 0, lastLineState2);
        }
    }

    public static void nextState(int[][] board, int col, int colum, int lastLineState) {
        int[][] step = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}};
        int sum = 0;
        for (int i = 0; i < step.length; i++) {
            int nextCol = col + step[i][0];
            int nextColum = colum + step[i][1];
            if (nextColum >= board[0].length || nextColum < 0 || nextCol >= board.length || nextCol < 0) {
                continue;
            }
            if (colum == 0 && nextCol < col) {
                sum += (lastLineState >> nextColum) & 1;
            } else {
                sum += (board[nextCol][0] >> nextColum) & 1;
            }
        }
        if (colum == 0) {
            if ((board[col][colum] & 1) == 1) {
                if (sum < 2) board[col][colum] = 0;
                else if (sum > 3) board[col][colum] = 0;
                else board[col][colum] = 1;

            } else {
                if (sum == 3) board[col][colum] = 1;
                else board[col][colum] = 0;
            }
            return;
        }
        if (board[col][colum] == 1) {
            if (sum < 2) board[col][colum] = 0;
            if (sum > 3) board[col][colum] = 0;
        } else if (board[col][colum] == 0) {
            if (sum == 3) board[col][colum] = 1;
        }
    }
}
