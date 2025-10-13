package org.dsa.revamp.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        // NOTE: Using the Two Pointer approach and handling duplicate cases
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = n - 1;

            while (j < k) {
                int target = nums[i] + nums[j] + nums[k];
                if (target > 0) {
                    k--;
                } else if (target < 0) {
                    j++;
                } else {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(data));
    }
}