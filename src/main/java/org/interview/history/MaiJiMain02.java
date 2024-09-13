package org.interview.history;

import java.util.Scanner;

/**
 * ClassName: Main4
 * Package: org.interview.current
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/9/13 23:08
 * @Version 1.0
 */
public class MaiJiMain02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] boxes = new int[n][];
        int colorMax = 0;
        for (int i = 0; i < n; i++) {
            String cur = scanner.nextLine();
            int colorCount = cur.length();
            colorMax = Math.max(colorMax, colorCount);
            boxes[i] = new int[colorCount];
            for (int j = 0; j < colorCount; j++) {
                boxes[i][j] = cur.charAt(j) - '0';
            }
        }
        int minOp = Integer.MAX_VALUE;
        // 尝试把每个箱子都当作全能箱子
        for (int quanNengBox = 0; quanNengBox < n; quanNengBox++) {
            int op = 0;
            boolean[] colorUsed = new boolean[colorMax];
            for (int i = 0; i < n; i++) {
                if (i == quanNengBox) continue;

                boolean[] boxUsed = new boolean[colorMax];
                for (int color = 0; color < colorMax; color++) {
                    if (boxes[i][color] > 0) {
                        boxUsed[color] = true;
                    }
                }

                for (int color = 0; color < colorMax; color++) {
                    if (boxUsed[color]) {
                        if (!colorUsed[color]) {
                            colorUsed[color] = true;
                        } else {
                            op++;
                        }
                    }
                }
            }
            minOp = Math.min(minOp, op);
        }
        System.out.println(minOp);
    }
}
