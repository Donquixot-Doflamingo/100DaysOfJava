# LeetCode 100 Problems - Revamp Plan

This document outlines the plan for implementing and testing solutions to a curated list of LeetCode problems as part of the "Revamp" mission. Each problem will be tackled systematically, focusing on robust solutions and thorough validation using the custom DSA testing framework.

---

## 🎯 Approach for Each Problem Solution

For each LeetCode problem listed below, the following steps will be taken:

1. **Problem Analysis**:

    * Understand the problem statement, constraints, and examples.
    * Identify edge cases and potential complexities.
    * Determine optimal data structures and algorithms.

2. **Implementation**:

    * Create a dedicated Java class for the problem (e.g., `TwoSum.java`, `ValidPalindrome.java`).
    * This class will implement the `ProblemTest<I, O>` interface, where `I` is the input type and `O` is the output type for the specific problem.
    * The `solveProblem(I input)` method will contain the core algorithm for the solution.

3. **Test Case Development (`loadTestCases()` method)**:

    * Develop a comprehensive set of test cases within the `loadTestCases()` method.
    * Include:

        * **Standard cases**: Typical inputs and expected outputs.
        * **Edge cases**: Minimum/maximum constraints, empty inputs, null inputs (if applicable), single-element inputs, etc.
        * **Negative cases**: Inputs that should lead to specific errors or non-standard behavior (if applicable).
    * Each test case will be an instance of `TestCase<I, O>`, providing clear input, expected output, and a descriptive label.

4. **Local Testing with `DSAProblemRunner`**:

    * Utilize the `DSAProblemRunner` to execute all developed test cases.
    * Analyze the output for correctness, performance (execution time), and any unexpected behavior.
    * Iteratively refine the `solveProblem()` implementation and test cases until all tests pass efficiently.

5. **Code Documentation**:

    * Add Javadoc comments to the problem class, methods, and any complex logic.
    * Explain the chosen algorithm, time and space complexity, and any significant design decisions.

---

## 📚 LeetCode Problem List

### I. Array & String Manipulation

* [x] **Valid Palindrome**
* [x] **Two Sum**
* [ ] **Longest Substring Without Repeating Characters**
* [ ] **3Sum**
* [ ] **Product of Array Except Self**
* [ ] **Find First and Last Position of Element in Sorted Array**
* [ ] **Search in Rotated Sorted Array**
* [ ] **Maximum Subarray**
* [ ] **Best Time to Buy and Sell Stock**
* [ ] **Contains Duplicate**
* [ ] **Subarray Sum Equals K**
* [ ] **Spiral Matrix**
* [ ] **Set Matrix Zeroes**
* [ ] **Rotate Image**
* [ ] **Largest Number (concatenation)**
* [ ] **Kth Smallest / Largest Element in matrix / array variants**
* [ ] **Find Minimum in Rotated Sorted Array II (with duplicates)**
* [ ] **Median of Two Sorted Arrays**
* [ ] **Split Array Largest Sum**

### II. Linked Lists

* [ ] **Reverse Linked List**
* [ ] **Merge Two Sorted Lists**
* [ ] **Intersection of Two Linked Lists**
* [ ] **Delete Node in a Linked List**
* [ ] **Reverse Linked List II**
* [ ] **Remove Nth Node From End**
* [ ] **Linked List Cycle / Cycle II**
* [ ] **Copy List with Random Pointer**
* [ ] **Sort List (merge sort on linked list)**
* [ ] **Merge k Sorted Lists**

### III. Trees & Graphs

* [ ] **Maximum Depth of Binary Tree**
* [ ] **Invert / Mirror Tree**
* [ ] **Symmetric Tree**
* [ ] **Balanced Binary Tree**
* [ ] **Minimum Depth of Binary Tree**
* [ ] **Level Order Traversal (BFS)**
* [ ] **Serialize and Deserialize Binary Tree**
* [ ] **Construct Binary Tree from Preorder & Inorder**
* [ ] **Lowest Common Ancestor (BST / general)**
* [ ] **Binary Tree Maximum Path Sum**
* [ ] **Number of Islands**
* [ ] **Clone Graph**
* [ ] **Course Schedule (cycle detection in directed graph)**
* [ ] **Course Schedule II (topological sort)**
* [ ] **Word Ladder**
* [ ] **Minimum Height Trees**
* [ ] **Graph Valid Tree / Check if Graph is Tree**
* [ ] **Alien Dictionary (topological on characters)**
* [ ] **Connected Components in Graph**
* [ ] **Reconstruct Itinerary / Hierholzer’s algorithm**

### IV. Dynamic Programming & Recursion

* [ ] **Climbing Stairs**
* [ ] **House Robber**
* [ ] **Unique Paths / Unique Paths II**
* [ ] **Longest Increasing Subsequence**
* [ ] **Partition Equal Subset Sum**
* [ ] **Coin Change**
* [ ] **Decode Ways**
* [ ] **Word Break**
* [ ] **Jump Game / Jump Game II**
* [ ] **Gas Station**

### V. Stack & Queue

* [ ] **Valid Parentheses**
* [ ] **Min Stack**
* [ ] **Next Greater Element I / II**
* [ ] **Daily Temperatures**
* [ ] **Evaluate Reverse Polish Notation**

### VI. Sliding Window & Monotonic Stack/Queue

* [ ] **Sliding Window Maximum**
* [ ] **Largest Rectangle in Histogram**
* [ ] **Trapping Rain Water**

### VII. Intervals

* [ ] **Merge Intervals**
* [ ] **Insert Interval**
* [ ] **Meeting Rooms / Meeting Rooms II**
* [ ] **Non‑overlapping Intervals**
* [ ] **Minimum Number of Arrows to Burst Balloons**
* [ ] **Task Scheduler**
* [ ] **Queue Reconstruction by Height**
* [ ] **Wiggle Sort**

### VIII. Backtracking & Advanced Recursion

* [ ] **Subsets**
* [ ] **Permutations**
* [ ] **Combination Sum**
* [ ] **Combination Sum II / Unique Combinations**
* [ ] **Generate Parentheses**
* [ ] **Letter Combinations of a Phone Number**
* [ ] **Word Search**
* [ ] **N-Queens**
* [ ] **Palindrome Partitioning**
* [ ] **Sudoku Solver**

### IX. Harder Variants & Challenge Problems

* [ ] **Clone Graph (duplicate, but sometimes harder variant)**
* [ ] **Alien Dictionary (duplicate, deeper variant)**
* [ ] **Merge k Sorted Lists (duplicate tough variant)**
* [ ] **Split Array Largest Sum (harder constraints)**
* [ ] **Median of Two Sorted Arrays (harder variant)**
* [ ] **Serialize / Deserialize (hard variant)**
* [ ] **Binary Tree Maximum Path Sum (harder variant or constraints)**
* [ ] **Reconstruct Itinerary / Eulerian Path variant**
* [ ] **Hard graph / backtracking hybrids**
* [ ] **(Catch-all) Very difficult challenge problems / extreme constraints**
