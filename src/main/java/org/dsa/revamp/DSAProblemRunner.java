package org.dsa.revamp;


import lombok.extern.slf4j.Slf4j;
import org.dsa.revamp.problems.ProblemTest;
import org.dsa.revamp.problems.TestCase;
import org.dsa.revamp.problems.impl.palindrome.PalindromeProblem;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Main runner class for executing DSA problem tests
 */
@Slf4j
public record DSAProblemRunner(ProblemTest<?, ?> problemTest) {

    /**
     * Run tests for a given problem implementation
     *
     * @param problem The problem implementation to test
     * @param <I>     Input type
     * @param <O>     Output type
     */
    public static <I, O> void runTests(ProblemTest<I, O> problem) {
        log.info("=".repeat(60));
        log.info("Running tests for: {}", problem.getProblemName());
        log.info("=".repeat(60));

        List<TestCase<I, O>> testCases = problem.loadTestCases();

        if (testCases == null || testCases.isEmpty()) {
            log.error("❌ No test cases found!");
            return;
        }

        int totalTests = testCases.size();
        int passedTests = 0;

        for (int i = 0; i < testCases.size(); i++) {
            TestCase<I, O> testCase = testCases.get(i);
            log.info("\n\uD83D\uDCCB Test Case {}:", i + 1);

            if (!testCase.description().isEmpty()) {
                log.info("   Description: {}", testCase.description());
            }

            log.info("   Input: {}", testCase.input());
            log.info("   Expected: {}", testCase.expectedOutput());

            try {
                long startTime = System.nanoTime();
                O actualOutput = problem.solveProblem(testCase.input());
                long endTime = System.nanoTime();
                double executionTime = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds

                log.info("   Actual: {}", actualOutput);
                log.info("   Execution Time: {} ms", executionTime);

                boolean passed = isEqual(testCase.expectedOutput(), actualOutput);

                if (passed) {
                    log.info("   ✅ PASSED");
                    passedTests++;
                } else {
                    log.error("   ❌ FAILED");
                }

            } catch (Exception e) {
                log.error("   ❌ FAILED with exception: {}", e.getMessage());
            }
        }

        log.info("\n{}", "=".repeat(60));
        log.info("Test Results: {}/{} passed {}%", passedTests, totalTests, (passedTests * 100.0 / totalTests));

        if (passedTests == totalTests) {
            log.info("🎉 All tests passed!");
        } else {
            log.error("⚠️  {} test(s) failed", (totalTests - passedTests));
        }
        log.info("=".repeat(60));
    }

    /**
     * Helper method to compare expected and actual outputs
     * Handles arrays, objects, and primitives
     */
    private static <O> boolean isEqual(O expected, O actual) {
        if (expected == null && actual == null) {
            return true;
        }

        if (expected == null || actual == null) {
            return false;
        }

        // Handle arrays
        if (expected.getClass().isArray() && actual.getClass().isArray()) {
            return Arrays.deepEquals(new Object[]{expected}, new Object[]{actual});
        }

        // Handle regular objects
        return Objects.equals(expected, actual);
    }

    /**
     * Main method for running individual problem tests
     * Usage: java org.dsa.revamp.DSAProblemRunner <ProblemClassName>
     */
    public static void main(String[] args) {
        DSAProblemRunner problemRunner = new DSAProblemRunner(new PalindromeProblem());
        try {
            runTests(problemRunner.problemTest);

        } catch (Exception e) {
            log.error("❌ Error running tests: {}", e.getMessage());
            e.printStackTrace();
        }
    }
}
