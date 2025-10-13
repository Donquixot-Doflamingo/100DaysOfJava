package org.dsa.revamp.easy;

public class LongestCommonPrefix {

    public static String solution(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            while (!s.startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] arr = {"flower", "flow"};
        System.out.println(solution(arr));
    }

}

