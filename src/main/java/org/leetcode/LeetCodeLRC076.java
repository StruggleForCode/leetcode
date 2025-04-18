package org.leetcode;

/**
 * ClassName: LeetCodeLRC076
 * Package: org.leetcode
 * Description:https://leetcode.cn/problems/xx4gT2/description/
 *             腾讯面试
 *             LCR 076. 数组中的第 K 个最大元素
 *             大根队特性：根节点最大，某个节点的值必然大于等于其子字节点（如果有的话）
 *
 * @Author LeeHao
 * @Create 2025/4/15 21:23
 * @Version 1.0
 */
public class LeetCodeLRC076 {
    private int size = 0;

    // 大根堆
    public int findKthLargest(int[] nums, int k) {


        return 0;
    }

    private void buildMaxHeap(int[] nums) {
        size = nums.length;
    }


    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return (i + 1) * 2 - 1;
    }

    private int rightChild(int i) {
        return (i + 1) * 2;
    }

    private void swap(int num[], int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    // 下沉节点，大根堆。
    private void sinkNode(int num[], int i) {
        int max = i;
        int leftChild = leftChild(i);
        int rightChild = rightChild(i);
        if (leftChild < size && num[leftChild] > num[max]) max = leftChild;
        if (rightChild < size && num[rightChild] > num[max]) max = rightChild;
        if (max != i) {
            swap(num, i, max);
            sinkNode(num, max);
        }
    }

    private int pop(int num[]) {
        swap(num, 0, size - 1);
        size--;
        sinkNode(num, 0);
        return  num[size - 1];
    }

    private void insert(int num[], int value) {

    }






}


/*

0 1 2 3 4 5 6 7 8 9 10 11 12

                       0
             1                  2
         3       4           5        6
       7   8   9  10      11   12  13    14

 */