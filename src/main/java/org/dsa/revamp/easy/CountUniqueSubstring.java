package org.dsa.revamp.easy;

import org.dsa.old.datastructures.trie.Trie;

public class CountUniqueSubstring {

    public static int solution(String key) {
        Trie trie = new Trie();
        for (int i = 0; i < key.length(); i++) {
            trie.insert(key.substring(i));
        }
        return Trie.count(trie);
    }
}
