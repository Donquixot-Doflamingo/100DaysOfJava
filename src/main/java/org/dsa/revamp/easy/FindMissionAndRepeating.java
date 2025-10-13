package org.dsa.revamp.easy;

import java.util.HashSet;
import java.util.Set;

public class FindMissionAndRepeating {

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        int[] freq = new int[size + 1];
        for (int[] ints : grid)
            for (int j = 0; j < n; j++)
                freq[ints[j]]++;

        int res[] = new int[2];
        res[0] = res[1] = -1;

        for (int num = 1; num <= size; num++) {
            if (freq[num] == 2)
                res[0] = num;
            if (freq[num] == 0)
                res[1] = num;

            if (res[0] != -1 && res[1] != -1)
                break;
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] data = {{1,3},{2,2}};
        for (int a : findMissingAndRepeatedValues(data)){
            System.out.println(a);
        }
    }
}
