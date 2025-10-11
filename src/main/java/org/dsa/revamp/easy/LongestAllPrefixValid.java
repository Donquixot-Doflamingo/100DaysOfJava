package org.dsa.revamp.easy;

import org.dsa.old.datastructures.trie.Trie;

public class LongestAllPrefixValid {

    public static String longestWord(Trie trie, StringBuilder temp, String currentBest) {
        String best = currentBest;

        for (int i = 0; i < 26; i++) {
            Trie child = trie.getChildren()[i];
            if (child != null && child.isEow()) {
                temp.append((char) (i + 'a'));

                if (temp.length() > best.length()) {
                    best = temp.toString();
                }

                best = longestWord(child, temp, best);
                temp.deleteCharAt(temp.length() - 1);
            }
        }

        return best;
    }

    public static String solution(String[] s) {
        Trie data = new Trie();
        for (String a : s) {
            data.insert(a);
        }
        return longestWord(data, new StringBuilder(), "");
    }

    public static void main(String[] args) {
        String[] arr = {"a", "banana", "app", "appl", "ap", "apple", "apply"};
        System.out.println("Answer is : " + solution(arr));

    }
}
