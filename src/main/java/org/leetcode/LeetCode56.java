package org.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * ClassName: LeetCode56
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/1/28 19:11
 * @Version 1.0
 */
public class LeetCode56 {
    public static void main(String[] args) {


    }
    @Test
    public void test01(){
        // int[][] intervals = {{15,18}, {2,6},{1,2},{2,4},{8,10},{1,3}};
        // int[][] intervals = {{15,18}, {2,6},{8,10},{1,3}};
        int[][] intervals = {{1,4}, {4,5}};
        int[][] ret = merge(intervals);
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i][0] + "  " + ret[i][1]);
        }
    }

    /**
     * 经典贪心，之前是做过类似题目
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            Node node = new Node(intervals[i][0], intervals[i][1]);
            list.add(node);
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
               if (o1.left - o2.left != 0) {
                   return o1.left - o2.left;
               }
               return o1.right - o2.right;
            }
        });
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).left + "  " + list.get(i).right);
//        }
        List<int[]> lists = new ArrayList<>();
        int start = list.get(0).left;
        int end = list.get(0).right;
        for (int i = 1; i < list.size(); i++) {
            int left = list.get(i).left;
            int right = list.get(i).right;
           if (left <= end && right >= end) {
                end = right;
            } else if (end < left) {
                lists.add(new int[]{start, end});
                start = left;
                end = right;
            }
        }
        lists.add(new int[]{start, end});
        int[][] ret = new int[lists.size()][2];
        for (int i = 0; i < lists.size(); i++){
            int[] tmp = lists.get(i);
            ret[i][0] = tmp[0];
            ret[i][1] = tmp[1];
        }
        return ret;
    }
    class Node {
        int left;
        int right;
        Node (int _left, int _right) {
            left = _left;
            right = _right;
        }
    }
}
