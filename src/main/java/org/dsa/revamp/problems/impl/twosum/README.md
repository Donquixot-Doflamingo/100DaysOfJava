## 🧩 Problem 2: Two Sum

### ✅ Problem Statement

Given an array of integers and a target value, determine whether any two numbers in the array add up to the target. The task is to return the indices (or another expected output format depending on the platform) of the two numbers that sum up to the target.

You are typically given:

* An array of integers
* A target value

Your objective (without detailing the solution logic here) is to **identify a pair of values** in the array that, when added together, equal the target.

---

### ⚠️ Constraints & Limitations

* **Duplicates**: The input array may contain duplicate values, which may affect index-based return approaches.
* **Order Sensitivity**: Some platforms expect indices, others expect values. Clarifying this is important.
* **Single Valid Pair**: Usually only one valid pair is expected, but in some variations, there may be multiple.
* **Array Size Limitations**: Large input sizes may require optimal solutions over brute-force approaches.
* **Negative Numbers**: The presence of negative values impacts how pairs are considered.
* **No Valid Pair Case**: Some versions of the problem may require handling scenarios where no solution exists.

---

### ✅ Input Examples (Without Solutions)
| Input                | Target | Expected Output Format | Why This Is Important                  |
| -------------------- | ------ | ---------------------- | -------------------------------------- |
| [2, 7, 11, 15]       | 9      | [0, 1]                 | Basic case                             |
| [3, 2, 4]            | 6      | [1, 2]                 | Normal case with middle elements       |
| [3, 3]               | 6      | [0, 1]                 | Duplicate numbers                      |
| [-1, -2, -3, -4, -5] | -8     | [2, 4]                 | Negative numbers                       |
| [0, 4, 3, 0]         | 0      | [0, 3]                 | Zero values                            |
| [1, 2, 3, 4, 5]      | 10     | []                     | No valid pair exists                   |
| [5, 5, 5, 5]         | 10     | [0, 1]                 | Multiple duplicates — first valid pair |
| [1, 2]               | 3      | [0, 1]                 | Minimum length array                   |
| [2, 7, 11, 15]       | 26     | [2, 3]                 | Sum with last two elements             |
| [-3, 4, 3, 90]       | 0      | [0, 2]                 | Mix of negative and positive numbers   |


---

### ✏️ My Solution (Code)

> *(You will write your code solution here)*

```
// Your implementation goes here
```

---

### 🧠 Implementation Logic

> *(Explain how your solution works — without writing the actual code here)*

---

### 🤔 Why I Chose This Approach

> *(Explain your reasoning — time complexity, space complexity, readability, etc.)*

---

### 📈 Time & Space Complexity

> *(Write the final complexity after coding your solution)*

---

### ✅ Final Thoughts / Learnings

> *(What you learned or observed solving this problem)*
