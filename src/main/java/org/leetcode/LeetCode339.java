package org.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName: LeetCode339
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/26 22:06
 * @Version 1.0
 */
public class LeetCode339 {

    @Test
    public void test() {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list2.add("b");
        list2.add("c");
        list3.add("bc");
        list3.add("cd");
        List<List<String>> equations = new ArrayList<>();
        equations.add(list1);
        equations.add(list2);
        equations.add(list3);
        double[] values = {1.5,2.5,5.0};
        calcEquation(equations, values, null);

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Integer> mapNode = new HashMap<>();
        int index = 0;
        for (int i = 0; i < equations.size(); i++) {
            List<String> curList = equations.get(i);
            String temp1 = curList.get(0);
            String temp2 = curList.get(1);
            curList.set(0, removeSameCharacters(temp1, temp2));
            curList.set(1, removeSameCharacters(temp2, temp1));
            //division(curList.get(0), curList.get(1));
            if (!mapNode.containsKey(curList.get(0))) {
                mapNode.put(curList.get(0), index++);
            }
            if (!mapNode.containsKey(curList.get(1))) {
                mapNode.put(curList.get(1), index++);
            }
        }
        double[][] map = new double[index + 1][index + 1];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 0;
            }
        }
        for (int i = 0; i < equations.size(); i++) {
            List<String> curList = equations.get(i);
            String from = curList.get(0);
            String to = curList.get(1);
            map[mapNode.get(from)][mapNode.get(to)] = values[i];
        }



//        for (int i = 0; i < index; i++) {
//            for (int j = 0; j < index; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
        double[] res = new double[1];
        return  res;
    }

    public String removeSameCharacters(String str1, String str2) {
        String regex = "[" + str2 + "]"; // 构造正则表达式，[...]表示不包含...的任意字符
        return str1.replaceAll(regex, "");
    }

    @Test
    public void testDivision() {
        String str1 = "bc";
        String str2 = "cd";
        String str11 = removeSameCharacters(str1, str2);
        String str22 = removeSameCharacters(str2, str1);

        System.out.println(str11);
        System.out.println(str22);
    }

    class Node {
        String str;
        double value;
        Node(String str, double value) {
            this.str = str;
            this.value = value;
        }
    }
}
