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

        // ✅ Additional cases you requested

        testCases.add(new TestCase<>(
                "",
                true,
                "Empty string"
        ));

        testCases.add(new TestCase<>(
                ".,,",
                true,
                "Only punctuation; considered empty after cleanup"
        ));

        testCases.add(new TestCase<>(
                "a",
                true,
                "Single character"
        ));

        testCases.add(new TestCase<>(
                "ab",
                false,
                "Two-character non-palindrome"
        ));

        testCases.add(new TestCase<>(
                "Able was I, ere I saw Elba!",
                true,
                "Mixed case and punctuation"
        ));

        testCases.add(new TestCase<>(
                "12321",
                true,
                "Numeric palindrome"
        ));

        testCases.add(new TestCase<>(
                "1231",
                false,
                "Numeric non-palindrome"
        ));

        testCases.add(new TestCase<>(
                "0P",
                false,
                "Digit and character mismatch"
        ));

        // ✅ Option 2: Keep emojis & compare directly

        testCases.add(new TestCase<>(
                "😊abba😊",
                true,
                "Emoji wrapping same characters"
        ));

        testCases.add(new TestCase<>(
                "🧡a🧡",
                true,
                "Emoji wrapping same character"
        ));

        testCases.add(new TestCase<>(
                "aa😊",
                false,
                "Extra emoji at the end breaks palindrome"
        ));

        testCases.add(new TestCase<>(
                "a😊a",
                false,
                "Emoji in the middle breaks direct equality"
        ));

        testCases.add(new TestCase<>(
                "Madam In Eden, I’m Adam",
                true,
                "Handles punctuation and case sensitivity"
        ));

        testCases.add(new TestCase<>(
                "Was it a car or a cat I saw?",
                true,
                "Long palindrome with punctuation and spaces"
        ));

        testCases.add(new TestCase<>(
                "  ",
                true,
                "Only spaces"
        ));

        // ✅ Accents kept as-is (Option 2)

        testCases.add(new TestCase<>(
                "Àbba",
                false,
                "Accent on first character breaks strict match"
        ));

        testCases.add(new TestCase<>(
                "Ésope reste ici et se repose",
                false,
                "Accented characters not normalized"
        ));

        testCases.add(new TestCase<>(
                "abaZ",
                false,
                "Wrong ending"
        ));

        testCases.add(new TestCase<>(
                "ZZZzzz",
                true,
                "Case-insensitive palindrome"
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
