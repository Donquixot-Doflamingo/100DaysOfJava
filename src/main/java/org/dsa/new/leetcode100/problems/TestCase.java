package problems;

/**
 * Represents a test case with input and expected output
 *
 * @param <I> Input type
 * @param <O> Output type
 */
public record TestCase<I, O>(I input, O expectedOutput, String description) {

    @Override
    public String toString() {
        return String.format("problems.TestCase{input=%s, expectedOutput=%s, description='%s'}",
                input, expectedOutput, description);
    }
}
