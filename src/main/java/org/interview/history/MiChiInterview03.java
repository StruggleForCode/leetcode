package org.interview.history;

/**
 * ClassName: ShowMeBug2
 * Package: org.interview.history
 * Description: 幂律科技面试
 *
 * @Author LeeHao
 * @Create 2024/5/13 19:45
 * @Version 1.0
 */

// 从上到下找到最短路径（n个数字之和最小,n为矩阵的行数），可以从第一行中的任何元素开始，只能往下层走，同时只能走向相邻的节点，
// 例如图中第一排 2 只能走向 第二排的 7、3；第二排的 7 可以走向第三排的 6、2、9
//
// | 5    | 8    | 1    | 2    |
// | 4    | 1    | 7    | 3    |
// | 3    | 6    | 2    | 9    |
//
// Input: [
//     [5, 8, 1, 2],
//     [4, 1, 7, 3],
//     [3, 6, 2, 9]
// ]
// Output: 4

public class MiChiInterview03 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5, 8, 1, 2},
                {4, 1, 7, 3},
                {3, 6, 2, 9}
        };

        int[][] temp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                temp[i][j] = 1000000000;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            temp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int minValue = temp[i - 1][j];
                if (j - 1 >= 0) {
                    minValue = Math.min(minValue, temp[i - 1][j - 1]);
                }
                if (j + 1 < matrix[i].length) {
                    minValue = Math.min(minValue, temp[i - 1][j + 1]);
                }
                temp[i][j] = Math.min(temp[i][j], matrix[i][j] + minValue);
            }
        }

        int cow = temp.length - 1;
        int res = temp[cow][0];
        for (int j = 0; j < temp[cow].length; j++) {
            if (temp[cow][j] < res) {
                res = temp[cow][j];
            }
        }
        System.out.println(res);
    }
}
