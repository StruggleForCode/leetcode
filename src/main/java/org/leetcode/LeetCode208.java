package org.leetcode;

import javafx.util.Pair;

/**
 * ClassName: LeetCode208
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/29 22:50
 * @Version 1.0
 */
public class LeetCode208 {
    class Trie {
        boolean isEnd;
        Trie[] next;
        public Trie() {
            this.isEnd = false;
            this.next = new Trie[26];
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new Trie();
                }
                node = node.next[c - 'a'];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                node = node.next[c - 'a'];
                if (node == null) {
                    return false;
                }
            }
            return node.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                node = node.next[c - 'a'];
                if (node == null) {
                    return false;
                }
            }
            return true;
        }
    }
}
