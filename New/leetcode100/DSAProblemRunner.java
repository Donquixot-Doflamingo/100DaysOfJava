import problems.ProblemTest;
import problems.TestCase;
import problems.impl.PalindromeProblem;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Main runner class for executing DSA problem tests
 */
public record DSAProblemRunner(ProblemTest<?, ?> problemTest) {

    /**
     * Run tests for a given problem implementation
     *
     * @param problem The problem implementation to test
     * @param <I>     Input type
     * @param <O>     Output type
     */
    public static <I, O> void runTests(ProblemTest<I, O> problem) {
        System.out.println("=".repeat(60));
        System.out.println("Running tests for: " + problem.getProblemName());
        System.out.println("=".repeat(60));

        List<TestCase<I, O>> testCases = problem.loadTestCases();

        if (testCases == null || testCases.isEmpty()) {
            System.out.println("❌ No test cases found!");
            return;
        }

        int totalTests = testCases.size();
        int passedTests = 0;

        for (int i = 0; i < testCases.size(); i++) {
            TestCase<I, O> testCase = testCases.get(i);
            System.out.println("\n📋 Test Case " + (i + 1) + ":");

            if (!testCase.description().isEmpty()) {
                System.out.println("   Description: " + testCase.description());
            }

            System.out.println("   Input: " + testCase.input());
            System.out.println("   Expected: " + testCase.expectedOutput());

            try {
                long startTime = System.nanoTime();
                O actualOutput = problem.solveProblem(testCase.input());
                long endTime = System.nanoTime();
                double executionTime = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds

                System.out.println("   Actual: " + actualOutput);
                System.out.printf("   Execution Time: %.3f ms%n", executionTime);

                boolean passed = isEqual(testCase.expectedOutput(), actualOutput);

                if (passed) {
                    System.out.println("   ✅ PASSED");
                    passedTests++;
                } else {
                    System.out.println("   ❌ FAILED");
                }

            } catch (Exception e) {
                System.out.println("   ❌ FAILED with exception: " + e.getMessage());
                e.printStackTrace();
            }
        }

        System.out.println("\n" + "=".repeat(60));
        System.out.printf("Test Results: %d/%d passed (%.1f%%)%n",
                passedTests, totalTests, (passedTests * 100.0 / totalTests));

        if (passedTests == totalTests) {
            System.out.println("🎉 All tests passed!");
        } else {
            System.out.printf("⚠️  %d test(s) failed%n", (totalTests - passedTests));
        }
        System.out.println("=".repeat(60));
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
     * Usage: java DSAProblemRunner <ProblemClassName>
     */
    public static void main(String[] args) {
        DSAProblemRunner problemRunner = new DSAProblemRunner(new PalindromeProblem());
        try {
            runTests(problemRunner.problemTest);

        } catch (Exception e) {
            System.out.println("❌ Error running tests: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
