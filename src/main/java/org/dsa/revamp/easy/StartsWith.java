package org.dsa.revamp.easy;

import org.dsa.old.datastructures.trie.Trie;

public class StartsWith {
    public static boolean solution(String[] words, String key) {
        Trie trie = new Trie();
        for (String s : words) {
            trie.insert(s);
        }
        return trie.prefixSearch(key);
    }

    public static void main(String[] args) {
        String[] s = {"a", "data", "one", "dog"};
        System.out.println(solution(s, "dato"));
    }
}
