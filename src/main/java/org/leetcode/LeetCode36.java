package org.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: LeetCode36
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2023/12/23 14:39
 * @Version 1.0
 */
public class LeetCode36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!isValidCows(board, i)) {
                return false;
            }
        }
        for (int i = 0; i < board[0].length; i++){
            if (!isValidColumns(board, i)) {
                return false;
            }
        }
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[i].length; j += 3) {
                if (!isValidSquare(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidCows(char[][] board, int cow) {
        Set<Character> set = new HashSet<>();
        for (int i  = 0; i < board[cow].length; i++) {
            Character character = board[cow][i];
            if (character == '.') {
                continue;
            }
            if (set.contains(character)) {
                return false;
            } else {
                set.add(character);
            }
        }
        return true;
    }

    public boolean isValidColumns(char[][] board, int columns) {
        Set<Character> set = new HashSet<>();
        for (int i  = 0; i < board.length; i++) {
            Character character = board[i][columns];
            if (character == '.') {
                continue;
            }
            if (set.contains(character)) {
                return false;
            } else {
                set.add(character);
            }
        }
        return true;
    }

    public boolean isValidSquare(char[][] board, int cow, int column) {
        Set<Character> set = new HashSet<>();
        for (int i  = cow; i < cow + 3; i++) {
            for (int j = column; j < column + 3; j++) {
                Character character = board[i][j];
                if (character == '.') {
                    continue;
                }
                if (set.contains(character)) {
                    return false;
                } else {
                    set.add(character);
                }
            }
        }
        return true;
    }
}
