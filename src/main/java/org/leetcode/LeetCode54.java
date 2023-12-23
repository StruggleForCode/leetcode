package org.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: LeetCode54
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2023/12/23 21:03
 * @Version 1.0
 */
public class LeetCode54 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12},
                {13,14,15,16}
        };
        List<Integer> list = spiralOrder(matrix);
        System.out.println(list);
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        // matrix[i][j] == 200 表示已经表里 题目给出：-100 <= matrix[i][j] <= 100
        List<Integer> res = new ArrayList<>();
        dfs(matrix, res, 0, 0, 0);
        return res;
    }

    public static void dfs(int[][] matrix, List<Integer> res, int cur_i, int cur_j, int directionIndex) {
        if (res.size() == matrix.length * matrix[0].length) {
            return;
        }
        res.add(matrix[cur_i][cur_j]);
        matrix[cur_i][cur_j] = 200;

        // 右 下 左 上
        int[][] step = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int next_i = cur_i + step[directionIndex][0];
        int next_j = cur_j + step[directionIndex][1];
        if (next_i >= matrix.length || next_i < 0 || next_j >= matrix[0].length || next_j < 0 || matrix[next_i][next_j] ==  200) {
            directionIndex = (directionIndex + 1) % 4;
        }
        next_i = cur_i + step[directionIndex][0];
        next_j = cur_j + step[directionIndex][1];
        dfs(matrix, res, next_i, next_j, directionIndex);
    }
}

/*
[[1, 2, 3, 4],
 [5, 6, 7, 8],
 [9,10,11,12],
 [13,14,15,16]]

 [1,2,3,4,8,12,16,15,14,13,9,10,11,7,6,5]

 [1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]
 */
