# 100 Days of Java - Data Structures and Algorithms

This repository serves as a comprehensive collection of Data Structures and Algorithms (DSA) solutions implemented in Java. It reflects a journey of learning and improvement, categorizing efforts into 'Old' (previous work) and a 'Revamp' (a mission for more structured and robust solutions).

## Project Structure

The project is organized into the following main sections:

- `src/main/java/org/dsa/Old/`: This directory contains my previous implementations of various DSA problems. These solutions were developed as part of an earlier learning phase. They have recently undergone a package restructuring to align with modern Java project conventions and to work seamlessly with Gradle.

- `src/main/java/org/dsa/new/leetcode100/`: This section is dedicated to my "revamp" mission. The goal here is to tackle a curated list of LeetCode problems (outlined in `plan.md`) with a more structured approach, focusing on clean code, efficient algorithms, and robust testing.

## The Revamp Mission

My mission for the "revamp" section is to:
1.  **Implement Solutions**: Provide clear and optimized solutions to challenging DSA problems.
2.  **Structured Testing**: Utilize a custom testing framework for thorough validation of each solution. This involves:
    -   **`ProblemTest<I, O>` Interface**: An interface defining `loadTestCases()` and `solveProblem()` methods for consistent problem definition.
    -   **`TestCase<I, O>` Class**: A generic class to encapsulate input and expected output for test scenarios.
    -   **`DSAProblemRunner`**: A main class to automate the execution of tests, report results (pass/fail, execution time), and provide a summary.
3.  **Documentation**: Ensure each solution is well-documented, explaining the approach, complexity analysis, and any key insights.

## Getting Started

This project uses Gradle as its build automation tool.

### Prerequisites

-   Java Development Kit (JDK) 17 or higher
-   Gradle (usually bundled with the project wrapper, `./gradlew`)

### Building the Project

To build the entire project, navigate to the root directory of the repository and run:

```bash
./gradlew build
```

This command will compile all Java source files, run any tests, and package the project.

### Running Specific DSA Solutions

To run a specific DSA problem's solution (e.g., from the `Old` folder or a new implementation):

1.  **Compile all classes**:
    ```bash
    ./gradlew compileJava
    ```
2.  **Run a specific class with a `main` method**:
    For example, to run `Day1.java` (assuming it has a `main` method):
    ```bash
    java -cp build/classes/java/main org.dsa.Old.Day1.Day1
    ```
    If you have a problem implementation that uses the `DSAProblemRunner` (from the revamp section, once implemented), you can run it like this (example for `TwoSumProblem`):
    ```bash
    java -cp build/classes/java/main org.dsa.new.leetcode100.DSAProblemRunner org.dsa.new.leetcode100.problems.impl.TwoSumProblem
    ```
    **Note**: You might need to adjust the classpath (`-cp`) based on your specific module structure and dependencies.

### Running Tests (for Revamp Section)

Once the testing framework and problem implementations are in place under `src/main/java/org/dsa/new/leetcode100/`, you can run all tests using Gradle:

```bash
./gradlew test
```

Or, to run a specific problem's tests via the `DSAProblemRunner` (as shown above):

```bash
java -cp build/classes/java/main org.dsa.new.leetcode100.DSAProblemRunner org.dsa.new.leetcode100.problems.impl.TwoSumProblem
```

## Contributing

Feel free to contribute by adding new DSA problems, optimizing existing solutions, or improving the testing framework.
