package org.dsa.revamp.problems.impl;

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
        // Convert to lowercase and keep only alphanumeric characters
        StringBuilder cleaned = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }
        
        String cleanedStr = cleaned.toString();
        int left = 0;
        int right = cleanedStr.length() - 1;
        
        while (left < right) {
            if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    @Override
    public String getProblemName() {
        return "Valid Palindrome (LeetCode #125)";
    }
}
