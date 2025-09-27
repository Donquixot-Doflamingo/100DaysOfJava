package org.dsa.revamp.problems.impl.twosum;

import org.dsa.revamp.inputs.TwoSumInput;
import org.dsa.revamp.problems.ProblemTest;
import org.dsa.revamp.problems.TestCase;

import java.util.*;

/**
 * Example implementation of problems.ProblemTest interface
 * Problem: Two Sum
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 */
public class TwoSumProblem implements ProblemTest<TwoSumInput, int[]> {

    @Override
    public List<TestCase<TwoSumInput, int[]>> loadTestCases() {
        List<TestCase<TwoSumInput, int[]>> testCases = new ArrayList<>();

        // Test Case 1
        testCases.add(new TestCase<>(
                new TwoSumInput(new int[]{2, 7, 11, 15}, 9),
                new int[]{0, 1},
                "Basic case: [2,7,11,15], target=9"
        ));

        // Test Case 2
        testCases.add(new TestCase<>(
                new TwoSumInput(new int[]{3, 2, 4}, 6),
                new int[]{1, 2},
                "Case: [3,2,4], target=6"
        ));

        // Test Case 3
        testCases.add(new TestCase<>(
                new TwoSumInput(new int[]{3, 3}, 6),
                new int[]{0, 1},
                "Duplicate numbers: [3,3], target=6"
        ));

        // Test Case 4
        testCases.add(new TestCase<>(
                new TwoSumInput(new int[]{-1, -2, -3, -4, -5}, -8),
                new int[]{2, 4},
                "Negative numbers: [-1,-2,-3,-4,-5], target=-8"
        ));

        // Test Case 5
        testCases.add(new TestCase<>(
                new TwoSumInput(new int[]{0, 4, 3, 0}, 0),
                new int[]{0, 3},
                "Zero values: [0,4,3,0], target=0"
        ));

        // Test Case 6
        testCases.add(new TestCase<>(
                new TwoSumInput(new int[]{1, 2, 3, 4, 5}, 10),
                new int[]{},
                "No valid pair: [1,2,3,4,5], target=10"
        ));

        // Test Case 7
        testCases.add(new TestCase<>(
                new TwoSumInput(new int[]{5, 5, 5, 5}, 10),
                new int[]{0, 1},
                "Multiple duplicates: [5,5,5,5], target=10"
        ));

        // Test Case 8
        testCases.add(new TestCase<>(
                new TwoSumInput(new int[]{1, 2}, 3),
                new int[]{0, 1},
                "Minimum length array: [1,2], target=3"
        ));

        // Test Case 9
        testCases.add(new TestCase<>(
                new TwoSumInput(new int[]{2, 7, 11, 15}, 26),
                new int[]{2, 3},
                "Sum with last two elements: [2,7,11,15], target=26"
        ));

        // Test Case 10
        testCases.add(new TestCase<>(
                new TwoSumInput(new int[]{-3, 4, 3, 90}, 0),
                new int[]{0, 2},
                "Mix of negative and positive numbers: [-3,4,3,90], target=0"
        ));

        return testCases;
    }


    @Override
    public int[] solveProblem(TwoSumInput input) {
        return null;
    }

    @Override
    public String getProblemName() {
        return "Two Sum Problem (LeetCode #1)";
    }
}

