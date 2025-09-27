package org.dsa.revamp.problems.impl.palindrome;

import org.dsa.revamp.problems.ProblemTest;
import org.dsa.revamp.problems.TestCase;

import java.util.*;

/**
 * Example implementation for String-based problems
 * Problem: Valid Palindrome
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 */
public class PalindromeProblem implements ProblemTest<String, Boolean> {

    @Override
    public List<TestCase<String, Boolean>> loadTestCases() {
        List<TestCase<String, Boolean>> testCases = new ArrayList<>();

        testCases.add(new TestCase<>(
                "A man, a plan, a canal: Panama",
                true,
                "Classic palindrome with spaces and punctuation"
        ));

        testCases.add(new TestCase<>(
                "race a car",
                false,
                "Not a palindrome"
        ));

        testCases.add(new TestCase<>(
                " ",
                true,
                "Single space (empty after cleanup)"
        ));

        testCases.add(new TestCase<>(
                "Madam",
                true,
                "Simple palindrome with mixed case"
        ));

        testCases.add(new TestCase<>(
                "No 'x' in Nixon",
                true,
                "Complex palindrome with apostrophe"
        ));

        return testCases;
    }

    @Override
    public Boolean solveProblem(String input) {
        input = Objects.isNull(input) ? input : input.trim();
        // return true if the string is empty of the size is 1
        if (Objects.isNull(input) || input.isEmpty() || input.length() == 1) {
            return true;
        }

        return false;
    }

    @Override
    public String getProblemName() {
        return "Valid Palindrome (LeetCode #125)";
    }
}
