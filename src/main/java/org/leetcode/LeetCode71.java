package org.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * ClassName: LeetCode71
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/1/31 20:36
 * @Version 1.0
 */
public class LeetCode71 {

    @Test
    public void test() {
        String path = "/a/./b/..///../c/";
        String path2 = "/home//foo/";
        String path3 = "/a/../../b/../c//.//";
        String path4 = "/a//b////c/d//././/..";
        System.out.println(simplifyPath(path4));
    }

    public String simplifyPath(String path) {
        Stack<String> dirStack = new Stack<>();
        String[] pathDir = path.split("/");
        for (int i = 0; i < pathDir.length; i++) {
            String curDir = pathDir[i];
            if (curDir.length() == 0 || curDir.equals(".")) {
                continue;
            }
//            if (curDir.equals(".")) {
//                if (!dirStack.empty()) {
//                    dirStack.pop();
//                }
//            }
            if (curDir.equals("..")) {
                if (!dirStack.empty()) {
                    dirStack.pop();
                }
            } else {
                dirStack.push(curDir);
            }
        }
        String ret = "";
        if (!dirStack.empty()) {
            while (!dirStack.empty()) {
                ret = "/" + dirStack.pop() + ret;
            }
        } else {
            ret += "/";
        }
        return ret;
    }
}

/*

/a/./b/../../c/

/Users/leehao/Learn/毕业论文相关/:/hell

 */
