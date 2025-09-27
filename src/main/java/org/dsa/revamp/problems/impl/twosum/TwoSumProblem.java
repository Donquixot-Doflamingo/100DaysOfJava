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

