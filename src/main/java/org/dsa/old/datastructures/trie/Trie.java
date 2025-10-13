package org.dsa.old.datastructures.trie;

import java.util.Map;

public class Trie {
    private final Trie[] children;
    private boolean eow;

    public Trie[] getChildren() {
        return children;
    }

    public boolean isEow() {
        return eow;
    }

    public Trie() {
        children = new Trie[26];
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }

    public void insert(String s) {
        Trie trie = this;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (trie.children[index] == null) {
                trie.children[index] = new Trie();
            }
            if (i == s.length() - 1) {
                trie.children[index].eow = true;
            }
            trie = trie.children[index];
        }
    }

    public boolean search(String s) {
        Trie trie = this;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (trie.children[index] == null) {
                return false;
            }
            if (i == s.length() - 1 && !trie.children[index].eow) {
                return false;
            }
            trie = trie.children[index];
        }
        return true;
    }

    public boolean prefixSearch(String s) {
        Trie trie = this;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (trie.children[index] == null) {
                return false;
            }
            trie = trie.children[index];
        }
        return true;
    }

    public static int count(Trie trie) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (trie.children[i] != null) {
                count += count(trie.children[i]);
            }
        }
        return count + 1;
    }

    public boolean hasSingleChild() {
        int nonNullCount = 0;
        for (Trie child : this.getChildren()) {
            if (child != null) {
                nonNullCount++;
                if (nonNullCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public Map.Entry<Trie, Integer> getSingleChild() {
        Trie singleChild = null;
        int index = -1;
        int nonNullCount = 0;

        for (int i = 0; i < this.children.length; i++) {
            Trie child = this.children[i];
            if (child != null) {
                nonNullCount++;
                if (nonNullCount > 1) {
                    return null; // More than one non-null child
                }
                singleChild = child;
                index = i;
            }
        }

        // Return only if exactly one non-null child exists
        return nonNullCount == 1 ? Map.entry(singleChild, index) : null;

    }
}
