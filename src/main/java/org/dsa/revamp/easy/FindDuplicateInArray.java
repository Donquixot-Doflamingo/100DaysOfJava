package org.dsa.revamp.easy;

public class FindDuplicateInArray {
    public static int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

    public static void main(String[] args) {
        int[] data = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(data));
    }
}
