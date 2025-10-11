package org.dsa.revamp.problems.impl.longestsubstring;

import lombok.extern.slf4j.Slf4j;
import org.dsa.revamp.common.StringUtils;
import org.dsa.revamp.problems.ProblemTest;
import org.dsa.revamp.problems.TestCase;

import java.util.*;

@Slf4j
public class LongestSubstring implements ProblemTest<String, Integer> {
    @Override
    public List<TestCase<String, Integer>> loadTestCases() {
        List<TestCase<String, Integer>> testCases = new ArrayList<>();

        // Test Case 1
        testCases.add(new TestCase<>(
                "abcabcbb",
                3,
                "Basic case: 'abcabcbb' → longest substring 'abc'"
        ));

        // Test Case 2
        testCases.add(new TestCase<>(
                "bbbbb",
                1,
                "All same characters: 'bbbbb' → longest substring 'b'"
        ));

        // Test Case 3
        testCases.add(new TestCase<>(
                "pwwkew",
                3,
                "Substring in middle: 'pwwkew' → longest substring 'wke'"
        ));

        // Test Case 4
        testCases.add(new TestCase<>(
                "",
                0,
                "Empty string: '' → longest substring length 0"
        ));

        // Test Case 5
        testCases.add(new TestCase<>(
                " ",
                1,
                "Single space character: ' ' → longest substring length 1"
        ));

        // Test Case 6
        testCases.add(new TestCase<>(
                "au",
                2,
                "Short string with unique characters: 'au'"
        ));

        // Test Case 7
        testCases.add(new TestCase<>(
                "dvdf",
                3,
                "Non-contiguous repeating character: 'dvdf' → longest substring 'vdf'"
        ));

        // Test Case 8
        testCases.add(new TestCase<>(
                "aab",
                2,
                "First repeating character scenario: 'aab' → longest substring 'ab'"
        ));

        // Test Case 9
        testCases.add(new TestCase<>(
                "tmmzuxt",
                5,
                "Longest substring at end: 'tmmzuxt' → longest substring 'mzuxt'"
        ));

        // Test Case 10
        testCases.add(new TestCase<>(
                "abcdeafgh",
                8,
                "Long substring with repeated character later: 'abcdeafgh' → longest substring 'bcdeafgh'"
        ));

        return testCases;
    }


    @Override
    public Integer solveProblem(String input) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        int maxLength = 0, start = 0;

        for (int end = 0; end < input.length(); end++) {
            char c = input.charAt(end);

            if (lastIndex.containsKey(c) && lastIndex.get(c) >= start) {
                start = lastIndex.get(c) + 1;
            }

            lastIndex.put(c, end);
            maxLength = Math.max(maxLength, end - start + 1);
            log.info("current char {}, current end {}, current start {}, current max {}, current lastIndex map {}", c, end, start, maxLength, lastIndex);
        }

        return maxLength;
    }

    @Override
    public String getProblemName() {
        return "Longest Substring Without Repeating Characters (#3 Leetcode)";
    }
}
