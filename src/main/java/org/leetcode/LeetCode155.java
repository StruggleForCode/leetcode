package org.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: LeetCode155
 * Package: org.leetcode
 * Description: 需要用到辅助栈
 * 按照上面的思路，我们只需要设计一个数据结构，使得每个元素 a 与其相应的最小值 m 时刻保持一一对应。因此我们可以使用一个辅助栈，与元素栈同步插入与删除，用于存储与每个元素对应的最小值。
 * 当一个元素要入栈时，我们取当前辅助栈的栈顶存储的最小值，与当前元素比较得出最小值，将这个最小值插入辅助栈中；
 * 当一个元素要出栈时，我们把辅助栈的栈顶元素也一并弹出；
 * 在任意一个时刻，栈内元素的最小值就存储在辅助栈的栈顶元素中。
 *
 * 还有更巧妙的方法，不要使用额外空间
 *  * stack用来存储和min的差值，min存储最小值，每次出栈的时候通过差值和当前min计算要出栈的值和之前的min
 *  * 如果差值diff大于等于0，说明要出栈的值大于等于当前min，那么要出栈的值在入栈的时候没有更新min，返回min+diff；
 *  * 如果插值diff小于0，说明当前要出栈的值就是min(因为入栈的时候我们选择的就是min和入栈元素的最小值)，同时，通过min-diff计算出之前min
 *  * 要注意的是diff可能会超出int范围，类似于 Integer.MAX_VALUE - 1 这种，所以diff要用Long存
 *
 *
 *
 * @Author LeeHao
 * @Create 2024/1/31 21:12
 * @Version 1.0
 */
public class LeetCode155 {

    private Stack<Integer> stack;
    private List<Integer> list;

    public LeetCode155() {
        stack = new Stack<>();
        list = new LinkedList<>();
    }

    public void push(int val) {
        stack.push(val);
        if (list.size() == 0) {
            list.add(val);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (val <= list.get(i)) {
                list.add(i, val);
                return;
            }
        }
    }

    public void pop() {
        if (!stack.empty()) {
            int val = stack.pop();
            for (int i = 0; i < list.size(); i++) {
                if (val == list.get(i)) {
                    list.remove(i);
                }
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return list.get(0);
    }
}
