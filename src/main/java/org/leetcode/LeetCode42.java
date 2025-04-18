package org.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * ClassName: LeetCode42
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/1 21:42
 * @Version 1.0
 */
public class LeetCode42 {
    @Test
    public void test01() {
        int[] height = {4,2,0,3,2,5};
        int[] height1= {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height2= {2, 0, 2};

        System.out.println(trap5(height1));
    }

    /**
     * 贪心
     * 策略：两个指针，谁小从谁的那头动，cur直到找到比当前小的，然后停止，接着left， right比较。
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left <= right) {
            int sum = 0;
            if (height[left] < height[right]) {
                int cur = left + 1;
                while (cur <= right) {
                    if (height[cur] >= height[left]) {
                        ans += (height[left] * (cur - left - 1)) - sum;
                        break;
                    }
                    sum += height[cur];
                    cur++;
                }
                left = cur;
            } else {
                int cur = right - 1;
                while (cur >= left) {
                    if (height[cur] >= height[right]) {
                        ans += (height[right] * (right - cur - 1)) - sum;
                        break;
                    }
                    sum += height[cur];
                    cur--;
                }
                right = cur;
            }
        }
        return ans;
    }

    public int trap2(int[] height) {
        int[] leftMaxHigh = new int[height.length];
        int maxLeft = height[0];
        for (int i = 0; i < height.length; i++) {
            if (maxLeft < height[i]) {
                maxLeft = height[i];
            }
            leftMaxHigh[i] = maxLeft;
         }

        int[] rightMaxHigh = new int[height.length];
        int maxRight = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            if (maxRight < height[i]) {
                maxRight = height[i];
            }
            rightMaxHigh[i] = maxRight;
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(leftMaxHigh[i], rightMaxHigh[i]) - height[i];
        }
        return  res;
    }

    public int trap3(int[] height) {
        int res = 0;

        int leftMaxHigh = height[0], rightMaxHigh = height[height.length - 1];
        int left = 0, right = height.length - 1;
        while (left < right) {
            leftMaxHigh = Math.max(height[left], leftMaxHigh);
            rightMaxHigh = Math.max(height[right], rightMaxHigh);
            if (leftMaxHigh < height[right]) {
                res += leftMaxHigh - height[left];
                left++;
            } else {
                res += rightMaxHigh - height[right];
                right--;
            }
        }

        return res;
    }

    public int trap4(int[] height) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        int bottomStack = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty()) {
                stack.add(height[i]);
                bottomStack = height[i];
                continue;
            }
            if (height[i] < bottomStack){
                stack.add(height[i]);
                continue;
            }
            while (!stack.isEmpty()) {
                res += bottomStack - stack.pop();
            }
            stack.push(height[i]);
            bottomStack = height[i];
        }
        return res;
    }

    public int trap5(int[] height) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    continue;
                }
                int left = stack.peek();
                int curWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                res += currHeight * curWidth;
            }
            stack.push(i);
        }
        return res;
    }

}
