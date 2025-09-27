/**
 * Represents a test case with input and expected output
 * @param <I> Input type
 * @param <O> Output type
 */
public class TestCase<I, O> {
    private final I input;
    private final O expectedOutput;
    private final String description;
    
    public TestCase(I input, O expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
        this.description = "";
    }
    
    public TestCase(I input, O expectedOutput, String description) {
        this.input = input;
        this.expectedOutput = expectedOutput;
        this.description = description;
    }
    
    public I getInput() {
        return input;
    }
    
    public O getExpectedOutput() {
        return expectedOutput;
    }
    
    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return String.format("TestCase{input=%s, expectedOutput=%s, description='%s'}", 
                           input, expectedOutput, description);
    }
}
