package org.leetcode;

import org.junit.jupiter.api.Test;

/**
 * ClassName: LeetCode211
 * Package: org.leetcode
 * Description:
 *
 * @Author LeeHao
 * @Create 2024/2/29 23:22
 * @Version 1.0
 */
public class LeetCode211 {

    @Test
    public void test() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search("mad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }

    class WordDictionary {
        boolean isEnd;
        WordDictionary[] children;
        public WordDictionary() {
            this.isEnd = false;
            this.children = new WordDictionary[26];
        }

        public void addWord(String word) {
            WordDictionary curNode = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curNode.children[c - 'a'] == null) {
                    curNode.children[c - 'a'] = new WordDictionary();
                }
                curNode = curNode.children[c - 'a'];
            }
            curNode.isEnd = true;
        }

        public boolean search(String word) {
            WordDictionary curNode = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c == '.') {
                    for (int j = 0; j < 26; j++) {
                        if (curNode.children[j] != null) {
                            curNode = curNode.children[j];
                            boolean flag = curNode.search(word.substring(i + 1, word.length()));
                            if (flag) return true;
                        }
                    }
                    return false;
                }
                if (curNode.children[c - 'a'] == null) {
                    return false;
                }
                curNode = curNode.children[c - 'a'];
            }
            return curNode.isEnd;
        }
    }
}
