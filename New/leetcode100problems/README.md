# DSA Problem Testing Framework

A comprehensive testing framework for Data Structures and Algorithms problems that allows you to implement solutions and automatically test them against multiple test cases.

## Framework Components

### 1. `ProblemTest<I, O>` Interface
The main interface that all DSA problem solutions must implement:
- `I`: Input type for the problem
- `O`: Output type for the problem

**Methods:**
- `List<TestCase<I, O>> loadTestCases()`: Load all test cases for the problem
- `O solveProblem(I input)`: Implement your algorithm here
- `String getProblemName()`: Optional method to provide problem name/description

### 2. `TestCase<I, O>` Class
Represents a single test case with:
- Input data
- Expected output
- Optional description

### 3. `DSAProblemRunner` Class
Main runner that executes tests and provides detailed results including:
- ✅/❌ Pass/Fail status for each test case
- Execution time measurement
- Detailed comparison of expected vs actual output
- Overall test summary with pass percentage

## How to Use

### Step 1: Implement the Interface
```java
public class YourProblem implements ProblemTest<InputType, OutputType> {
    
    @Override
    public List<TestCase<InputType, OutputType>> loadTestCases() {
        List<TestCase<InputType, OutputType>> testCases = new ArrayList<>();
        
        // Add your test cases
        testCases.add(new TestCase<>(
            inputData,
            expectedOutput,
            "Test case description"
        ));
        
        return testCases;
    }
    
    @Override
    public OutputType solveProblem(InputType input) {
        // Implement your algorithm here
        return result;
    }
}
```

### Step 2: Run Tests
You can run tests in multiple ways:

**Option 1: Direct execution**
```java
public static void main(String[] args) {
    YourProblem problem = new YourProblem();
    DSAProblemRunner.runTests(problem);
}
```

**Option 2: Using the runner**
```bash
javac *.java
java DSAProblemRunner YourProblem
```

## Examples

### Example 1: Two Sum Problem
```java
public class TwoSumProblem implements ProblemTest<TwoSumInput, int[]> {
    // Implementation with array input and array output
}
```

### Example 2: Palindrome Problem
```java
public class PalindromeProblem implements ProblemTest<String, Boolean> {
    // Implementation with string input and boolean output
}
```

## Features

- **Generic Type Support**: Works with any input/output types
- **Detailed Test Results**: Shows execution time, expected vs actual output
- **Exception Handling**: Catches and reports runtime errors
- **Array Comparison**: Properly handles array comparisons
- **Flexible Input Types**: Support for simple types, custom objects, arrays, etc.
- **Beautiful Output**: Color-coded results with emojis for easy reading

## Sample Output
```
============================================================
Running tests for: Two Sum Problem (LeetCode #1)
============================================================

📋 Test Case 1:
   Description: Basic case: [2,7,11,15], target=9
   Input: nums=[2, 7, 11, 15], target=9
   Expected: [0, 1]
   Actual: [0, 1]
   Execution Time: 0.123 ms
   ✅ PASSED

============================================================
Test Results: 4/4 passed (100.0%)
🎉 All tests passed!
============================================================
```

## Best Practices

1. **Create meaningful test cases**: Include edge cases, boundary conditions, and typical scenarios
2. **Use descriptive names**: Make test case descriptions clear and informative
3. **Handle exceptions**: Your `solveProblem` method should handle invalid inputs gracefully
4. **Custom input classes**: For complex inputs, create dedicated input classes (like `TwoSumInput`)
5. **Measure performance**: The framework automatically measures execution time for performance analysis

## Getting Started

1. Copy the framework files to your project
2. Look at the example implementations (`TwoSumProblem.java`, `PalindromeProblem.java`)
3. Create your own problem class implementing `ProblemTest`
4. Add test cases in `loadTestCases()`
5. Implement your algorithm in `solveProblem()`
6. Run and validate your solution!

Happy coding! 🚀
