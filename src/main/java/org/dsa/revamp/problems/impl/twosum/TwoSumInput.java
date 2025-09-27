package org.dsa.revamp.problems.impl.twosum;

import java.util.Arrays;

/**
 * Input class for Two Sum problem
 */
record TwoSumInput(int[] nums, int target) {

    @Override
    public String toString() {
        return String.format("nums=%s, target=%d", Arrays.toString(nums), target);
    }
}
