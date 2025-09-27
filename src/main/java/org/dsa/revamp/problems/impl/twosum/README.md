## 🧩 Problem 2: Two Sum

### ✅ Problem Statement

Given an array of integers and a target value, determine whether any two numbers in the array add up to the target. The
task is to return the indices (or another expected output format depending on the platform) of the two numbers that sum
up to the target.

You are typically given:

* An array of integers
* A target value

Your objective (without detailing the solution logic here) is to **identify a pair of values** in the array that, when
added together, equal the target.

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
|----------------------|--------|------------------------|----------------------------------------|
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

```java

@Override
public int[] solveProblem(TwoSumInput input) {
    int[] arr = input.nums();
    int target = input.target();
    if (arr.length < 2) {
        return new int[]{};
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
        int complement = target - arr[i];
        if (map.containsKey(complement)) {
            return new int[]{map.get(complement), i};
        }
        map.put(arr[i], i);
    }
    return new int[]{};
}
```

---

### 🧠 Implementation Logic

* Iterate through the array once.
* For each element, calculate the **complement** needed to reach the target.
* Check if the complement already exists in a **map of previously seen elements**.

    * If yes → return the indices immediately.
    * If no → add the current element and its index to the map.
* If no valid pair is found after iterating, return an empty array.

This ensures a **single-pass solution** that efficiently finds the pair while handling duplicates.

---

### **Example:**

**Input:** `arr = [2, 7, 11, 15]`, `target = 9`

We want to find indices of two numbers that sum to 9.

---

### **Step-by-Step Map Evolution**

| Iteration | Current Element (arr[i]) | Complement (target - arr[i]) | Map Before Insertion        | Complement Found? | Action            |
|-----------|--------------------------|------------------------------|-----------------------------|-------------------|-------------------|
| 0         | 2                        | 7                            | {}                          | No                | Insert `2 -> 0`   |
| 1         | 7                        | 2                            | {2 -> 0}                    | Yes               | Return `[0, 1]` ✅ |
| 2         | 11                       | -                            | Not reached (already found) | -                 | -                 |
| 3         | 15                       | -                            | Not reached                 | -                 | -                 |

---

### **Explanation**

1. Start with an **empty map**.
2. For `arr[0] = 2`, complement = 7 → map is empty → insert `2 -> 0`.
3. For `arr[1] = 7`, complement = 2 → map contains 2 → **pair found** → return `[0, 1]`.
4. Remaining elements are **ignored** because we already found a valid pair.

---

### **Visual Diagram**

```
Step 0: Map = {}
Step 1: arr[0] = 2 → complement 7 not in map → add 2:0 → Map = {2:0}
Step 2: arr[1] = 7 → complement 2 found in map → return [0,1]
```

✅ **Key Takeaways**

* Map stores only elements **already visited**, not future elements.
* Checking complement **before inserting current element** ensures correct handling of duplicates.
* Single-pass → **O(n) time**.

---

### 🤔 Why I Chose This Approach

* **Time Efficiency**: Single-pass → O(n) time complexity.
* **Space Efficiency**: Stores elements in a hash map → O(n) space complexity.
* **Simplicity**: Easy to read and understand.
* **Correctness with Duplicates**: By checking for the complement before inserting, duplicates are handled correctly.
* **Early Return**: Stops immediately after finding the first valid pair, avoiding unnecessary iterations.

---

### 📈 Time & Space Complexity

* **Time Complexity**: O(n) — Each element is processed exactly once.
* **Space Complexity**: O(n) — Hash map stores at most all elements of the array.

**Worst-case scenario:** array contains all duplicates — still O(n) time on average.

---

### ✅ Final Thoughts / Learnings

* The hash map approach is ideal for Two Sum because it reduces a brute-force O(n²) problem to O(n).
* Handling duplicates carefully ensures correctness.
* Early return in a single-pass loop is a simple but powerful optimization.
* This problem reinforces the **value of hashing for fast lookups** in algorithm design.