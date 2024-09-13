package org.interview.history;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ClassName: Main2
 * Package: org.interview.current
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/9/13 20:13
 * @Version 1.0
 */
public class DiDiMain02 {

    class Order {
        int op;
        int x;
        Order(int op, int x) {
            this.op = op;
            this.x = x;
        }
    }

    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int[][] ops = new int[n][2];
            ArrayList<Order> orders = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                orders.add(new Order(a, b));
                ops[j][0] = scanner.nextInt();
                ops[j][1] = scanner.nextInt();
            }
            System.out.println(judge(ops, n));
        }
    }

    public static String judge(int[][] ops, int n) {
        int maxLimit = 0x3f3f3f3f;
        int minLimit = -1;
        for (int i = 0; i < n; i++) {
            int op = ops[i][0];
            int x = ops[i][1];

            if (op == 1) {
                if (x <= minLimit) {
                    return "NO";
                }
                maxLimit = Math.max(maxLimit, x - 1);
            } else if (op == -1) {
                if (x >= maxLimit) {
                    return "NO";
                }
                maxLimit = Math.max(minLimit, x + 1);
            } else {
                if (!(minLimit < x && x <maxLimit)) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
}

/*
2
2
1 1
-1 2
5
0 2
-1 3
-1 4
0 1
-1 5

 */