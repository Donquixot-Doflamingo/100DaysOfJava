package org.dsa.old.datastructures.trie;

public class Trie {
    private final Trie[] childs;
    private boolean eow;

    public Trie() {
        childs = new Trie[26];
        for (int i = 0; i < 26; i++) {
            childs[i] = null;
        }
    }

    public void insert(String s) {
        Trie trie = this;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (trie.childs[index] == null) {
                trie.childs[index] = new Trie();
            }
            if (i == s.length() - 1) {
                trie.childs[index].eow = true;
            }
            trie = trie.childs[index];
        }
    }

    public boolean search(String s) {
        Trie trie = this;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (trie.childs[index] == null) {
                return false;
            }
            if (i == s.length() - 1 && !trie.childs[index].eow) {
                return false;
            }
            trie = trie.childs[index];
        }
        return true;
    }
}
