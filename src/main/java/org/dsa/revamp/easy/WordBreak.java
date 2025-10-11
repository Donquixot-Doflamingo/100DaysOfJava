package org.dsa.revamp.easy;

import org.dsa.old.datastructures.trie.Trie;

public class WordBreak {

    private static final Trie trie = new Trie();

    public static boolean wordBreak(String key) {
        if (key.isEmpty()) return true;
        int n = key.length();
        for (int i = 1; i <= n; i++) {
            if (trie.search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static void solution(String[] words, String str) {
        for (String s : words) {
            trie.insert(s);
        }
        System.out.println(wordBreak(str));

    }
}
