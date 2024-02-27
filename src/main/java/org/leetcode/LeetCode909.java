package org.leetcode;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: LeetCode909
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/27 22:42
 * @Version 1.0
 */
public class LeetCode909 {

    @Test
    public void testSnakesAndLadders() {
        int[][] board = {
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}
        };
        int[][] board2 = {
                {-1, 10, -1, 15, -1},
                {-1, -1, 18,  2, 20},
                {-1, -1, 12, -1, -1},
                { 2,  4, 11, 18,  8},
                {-1, -1, -1, -1, -1}
        };
        System.out.println(snakesAndLadders(board2));
    }

    public int snakesAndLadders(int[][] board) {
        int boardSize = board.length;
        int[] finalCoordinate = coordinate(boardSize * boardSize, boardSize);
        // 对于终点有梯子，或者蛇尾，直接返回-1，不可能到达。
        if (board[finalCoordinate[0]][finalCoordinate[1]] != -1) return -1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 0));
        int n2 = boardSize * boardSize;
        int res = n2;
        int nums = n2;
        int[][] map = new int[boardSize][boardSize];
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (curNode.value == n2) {
                res = curNode.number;
                break;
            }
            int[] curCoordinate =  coordinate(curNode.value, boardSize);
            map[curCoordinate[0]][curCoordinate[1]]++;
            if (map[curCoordinate[0]][curCoordinate[1]] >= n2) {
                return -1;
            }
            for (int i = 1; i <= 6; i++) {
                int next = curNode.value + i;
                if (next > n2) break;
                if (next == n2) {
                    return curNode.number + 1;
                }
                int[] nextCoordinate = coordinate(next, boardSize);
                int value = board[nextCoordinate[0]][nextCoordinate[1]];
                if (value == -1) {
                    queue.offer(new Node(next, curNode.number + 1));
                } else {
                    queue.offer(new Node(value, curNode.number + 1));
                }
            }
        }
        return res;
    }

    @Test
    public void testCoordinate() {
        int[] res = coordinate(36, 6);
        System.out.println(res[0] + " " + res[1]);
    }


    public int[] coordinate(int num, int boardSize) {
        int row = (boardSize * boardSize - num) / boardSize;
        int line = -1;
        if (boardSize % 2 == 0) {
            line = row % 2 == 1 ? boardSize - (boardSize * boardSize - num) % boardSize - 1 : (boardSize * boardSize - num) % boardSize;
        } else {
            line = row % 2 == 0 ? boardSize - (boardSize * boardSize - num) % boardSize - 1 : (boardSize * boardSize - num) % boardSize;
        }
        return new int[]{row, line};
    }

    class Node {
        int value;
        int number;
        Node (int value, int number) {
            this.value = value;
            this.number = number;
        }
    }
}
