package org.leetcode;

import java.util.Stack;

/**
 * ClassName: LeetCode150
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/3 20:43
 * @Version 1.0
 */
public class LeetCode150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String cur = tokens[i];
            if (cur.equals("+")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 + num2);
            } else if (cur.equals("-")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 - num2);
            } else if (cur.equals("*")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 * num2);
            } else if (cur.equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 / num2);
            } else {
                stack.push(Integer.valueOf(cur));
            }
        }
        return stack.pop();
    }
}
