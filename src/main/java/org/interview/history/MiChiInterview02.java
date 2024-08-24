package org.interview.history;

import java.util.*;

/**
 * ClassName: ShowMeBug
 * Package: org.interview.history
 * Description: 幂律科技面试
 *
 * @Author LeeHao
 * @Create 2024/5/13 19:10
 * @Version 1.0
 */
// 现在数据库有一张表，用来存储一个多叉树，id为主键，pid 表示父节点的 id，已知 "-1" 表示根节点，现在要求打印出从根节点到每个子节点的路径（可以是无序的）。
//
// | id      | pid    |
// |---------|--------|
// | "A"     | "-1"   |
// | "A-1"   | "A"    |
// | "A-2"   | "A"    |
// | "A-3"   | "A"    |
// | "A-2-1" | "A-2"  |
// | "A-2-2" | "A-2"  |
// | "A-2-3" | "A-2"  |
//
// Input: [
//   {
//       "id": "A",
//       "pid": "-1"
//   },
//   {
//       "id": "A-1",
//       "pid": "A"
//   },
//   {
//       "id": "A-2",
//       "pid": "A"
//   },
//   {
//       "id": "A-3",
//       "pid": "A"
//   },
//   {
//       "id": "A-2-1",
//       "pid": "A-2"
//   },
//   {
//       "id": "A-2-2",
//       "pid": "A-2"
//   },
//   {
//       "id": "A-2-3",
//       "pid": "A-2"
//   }
// ]
// Output: [
//   "/A",
//   "/A/A-1",
//   "/A/A-2",
//   "/A/A-3",
//   "/A/A-2/A-2-1",
//   "/A/A-2/A-2-2",
//   "/A/A-2/A-2-3",
// ]

class Node {
    Node(String ID, String PID) {
        this.ID = ID;
        this.PID = PID;
    }
    public String ID; // 节点ID
    public String PID; // 父节点ID
}

public class MiChiInterview02 {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node("A", "-1"));
        // nodes.add(new Node("B", "-1"));
        nodes.add(new Node("A-1", "A"));
        nodes.add(new Node("A-2", "A"));
        nodes.add(new Node("A-3", "A"));
        nodes.add(new Node("A-2-1", "A-2"));
        nodes.add(new Node("A-2-2", "A-2"));
        nodes.add(new Node("A-2-3", "A-2"));
        nodes.add(new Node("A-2-4", "A-2"));

        Map<String, List<String>> map = new HashMap<>();
        String rootNode = null;
        for (int i = 0; i < nodes.size(); i++) {
            Node curNode = nodes.get(i);
            String curNodeId = curNode.ID;
            String curNodePid = curNode.PID;
            if (map.containsKey(curNodePid)) {
                List<String> list = map.get(curNodePid);
                list.add(curNode.ID);
                map.put(curNodePid, list);
            }
            List<String> list = new ArrayList<>();
            map.put(curNodeId, list);
            if (curNodePid == "-1") {
                rootNode = curNodeId;
            }
        }

        List<String> res = new ArrayList<>();
        dfs(map, rootNode,"", res);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static void dfs(Map<String, List<String>> map, String curNode, String url, List<String> res) {
        List<String> list = map.get(curNode);
        url += "/" + curNode;
        res.add(url);
        if (list.size() == 0) return;
        for (int i = 0; i < list.size(); i++) {
            dfs(map, list.get(i), url, res);
        }
    }
}