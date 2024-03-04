package org.leetcode;

import org.junit.jupiter.api.Test;

/**
 * ClassName: LeetCode74
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/3/4 22:13
 * @Version 1.0
 */
public class LeetCode74 {

    @Test
    public void test() {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int target = 13;
        System.out.println(searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int cow = -1;
        int up = 0;
        int down = matrix.length - 1;
        int n = matrix.length;
        int m = matrix[0].length;
        while (up <= down) {
            int mid = (down - up) / 2 + up;
            if (matrix[mid][0] <= target && target <= matrix[mid][m - 1]) {
                cow = mid;
                break;
            }
            if (matrix[mid][m - 1] < target) {
                up = mid + 1;
            }
            if (matrix[mid][0] > target) {
                down = mid - 1;
            }
        }
        if (cow == -1) return false;
        int left = 0;
        int right = matrix[cow].length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (matrix[cow][mid] < target) {
                left = mid + 1;
            } else if (matrix[cow][mid] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}