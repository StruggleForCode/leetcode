package org.leetcode;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * ClassName: LeetCode339
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/26 22:06
 * @Version 1.0
 */
public class LeetCode399 {

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

        List<String> list4 = new ArrayList<>();
        list4.add("a");
        list4.add("aa");
        List<List<String>> equations2 = new ArrayList<>();
        equations2.add(list4);
        double[] values2 = {9.0};
        List<String> list5 = new ArrayList<>();
        list5.add("aa");
        list5.add("a");
        List<String> list6 = new ArrayList<>();
        list6.add("aa");
        list6.add("aa");
        List<List<String>> queries2 = new ArrayList<>();
        queries2.add(list5);
        queries2.add(list6);

        double[] doubles = calcEquation(equations, values, null);
        System.out.println(doubles);

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Integer> mapNode = new HashMap<>();
        int index = 0;
        for (int i = 0; i < equations.size(); i++) {
            List<String> curList = equations.get(i);
            String temp1 = curList.get(0);
            String temp2 = curList.get(1);
            Pair<String, String> pair = resolveSameCharacters(temp1, temp2);
            curList.set(0, pair.getKey());
            curList.set(1, pair.getValue());
            //division(curList.get(0), curList.get(1));
            if (!mapNode.containsKey(curList.get(0))) {
                mapNode.put(curList.get(0), index++);
            }
            if (!mapNode.containsKey(curList.get(1))) {
                mapNode.put(curList.get(1), index++);
            }
        }
        double[][] map = new double[index][index];
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

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == j) map[i][j] = 1;
                if (map[i][j] != 0 && map[j][i] == 0) {
                    map[j][i] = 1 / map[i][j];
                }
            }
        }


        for (int i = 0; i < index; i++) {
            for (int j = 0; j < index; j++) {
                for (int k = 0; k < index; k++) {
                    if (map[i][k] == 0 || map[k][j] == 0) continue;
                    map[i][j] = map[i][k] * map[k][j];
                }
            }
        }
//        for (int i = 0; i < index; i++) {
//            for (int j = 0; j < index; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> curList = queries.get(i);
            String temp1 = curList.get(0);
            String temp2 = curList.get(1);
            if (temp1.length() > 1 || temp2.length() > 1) {
                Pair<String, String> pair = resolveSameCharacters(temp1, temp2);
                curList.set(0, pair.getKey());
                curList.set(1, pair.getValue());
            }
            temp1 = curList.get(0);
            temp2 = curList.get(1);
            if (mapNode.containsKey(temp1) && mapNode.containsKey(temp2)) {
                double temp = map[mapNode.get(temp1)][mapNode.get(temp2)];
                if (temp == 0) {
                    res[i] = -1;
                } else {
                    res[i] = temp;
                }
            } else {
                res[i] = -1;
            }
        }
        return  res;
    }

    public String removeSameCharacters(String str1, String str2) {
        String regex = "[" + str2 + "]"; // 构造正则表达式，[...]表示不包含...的任意字符
        return str1.replaceAll(regex, "");
    }

    @Test
    public void testResolveSameCharacters() {
        String str1 = "aab";
        String str2 = "aa";
        System.out.println(resolveSameCharacters(str1, str2));
    }

    public Pair<String,String> resolveSameCharacters(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        int index1 = 0;
        int index2 = 0;
        Set<Character> set = new HashSet<>();
        while (index1 < chars1.length && index2 < chars2.length) {
            if (chars1[index1] < chars2[index2]) {
                index1++;
            } else if (chars1[index1] > chars2[index2]) {
                index2++;
            } else {
                set.add(chars1[index1]);
                chars1[index1] = '#';
                chars2[index2] = '#';
                index1++;
                index2++;
            }
        }
        String res1 = "";
        String res2 = "";
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != '#') {
                res1 += chars1[i];
            }
        }
        for (int i = 0; i < chars2.length; i++) {
            if (chars2[i] != '#') {
                res2 += chars2[i];
            }
        }
        char ch = '#';
        if (set.iterator().hasNext()) {
            ch = set.iterator().next();
        }
        if (res1.equals("") || res2.equals("")) {
            res1 += ch;
            res2 += ch;
        }
        chars1 = res1.toCharArray();
        chars2 = res2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        res1 = String.copyValueOf(chars1);
        res2 = String.copyValueOf(chars2);
        return new Pair<>(res1, res2);
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
