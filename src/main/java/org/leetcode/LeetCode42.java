package org.leetcode;

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
    public void test01() {
        int[] height = {4,2,0,3,2,5};
        int[] height1= {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height2= {2, 0, 2};

        System.out.println(trap(height));
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
}
