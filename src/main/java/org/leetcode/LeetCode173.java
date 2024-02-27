package org.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: LeetCode173
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/21 21:44
 * @Version 1.0
 */
public class LeetCode173 {
    class BSTIterator {

        private List<Integer> list;
        private int index;

        public BSTIterator(TreeNode root) {
            this.list = new ArrayList<>();
            this.index = 0;
            deepTree(root);
            int minValue = list.get(0);
            int minindex = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) < minValue) {
                    minindex = i;
                    minValue = list.get(i);
                }
                //System.out.println(list.get(i));
            }
            this.index = minindex;
        }

        public void deepTree(TreeNode root) {
            if (root == null) {
                return;
            }
            deepTree(root.left);
            list.add(root.val);
            deepTree(root.right);
        }


        public int next() {
            return list.get(this.index++);
        }

        public boolean hasNext() {
            return this.index >= this.list.size()  ? false : true;
        }
    }
}
