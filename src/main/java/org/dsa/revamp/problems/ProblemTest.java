package org.dsa.revamp.problems;

import java.util.List;

/**
 * Interface for DSA problem testing framework
 * @param <I> Input type for the problem
 * @param <O> Output type for the problem
 */
public interface ProblemTest<I, O> {
    
    /**
     * Load test cases for the problem
     * @return List of problems.TestCase objects containing input and expected output
     */
    List<TestCase<I, O>> loadTestCases();
    
    /**
     * Solve the problem with given input
     * @param input The input for the problem
     * @return The solution/output for the given input
     */
    O solveProblem(I input);
    
    /**
     * Get the name/description of the problem
     * @return Problem name or description
     */
    default String getProblemName() {
        return this.getClass().getSimpleName();
    }
}
