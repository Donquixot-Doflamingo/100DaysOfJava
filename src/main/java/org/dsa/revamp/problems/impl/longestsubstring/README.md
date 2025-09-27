## 🧩 Problem 3: Longest Substring Without Repeating Characters

### ✅ Problem Statement

Given a string, find the length of the longest substring without repeating characters. The goal is to identify the maximum length of a contiguous sequence where **no character repeats**.

You are typically given:

* A string consisting of letters, digits, symbols, or spaces.

Your objective (without detailing the solution logic here) is to **find the length of the longest substring** where each character appears only once.

LeetCode Reference: [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

---

### ⚠️ Constraints & Limitations

* **String Length**: Can vary from empty (`""`) to very large lengths (up to 10⁵ or more).
* **Character Set**: Can include uppercase, lowercase, digits, symbols, and spaces.
* **Empty String**: Edge case where input string has no characters.
* **All Unique / All Same**: Strings where all characters are unique or all the same.
* **Efficiency**: Large input sizes require an optimized approach (usually O(n) time).

---

### ✅ Input Examples (Without Solutions)

| Input       | Expected Output | Why This Is Important                        |
| ----------- | --------------- | -------------------------------------------- |
| "abcabcbb"  | 3               | Substring "abc" is the longest               |
| "bbbbb"     | 1               | All characters are the same                  |
| "pwwkew"    | 3               | Substring "wke" is the longest               |
| ""          | 0               | Empty string edge case                       |
| " "         | 1               | Single space character                       |
| "au"        | 2               | Short string with unique characters          |
| "dvdf"      | 3               | Non-contiguous repeating character case      |
| "aab"       | 2               | First repeating character scenario           |
| "tmmzuxt"   | 5               | Substring "mzuxt" is the longest             |
| "abcdeafgh" | 8               | Long substring with repeated character later |

---

### ✏️ My Solution (Code)

*(To be filled later)*

---

### 🧠 Implementation Logic

*(To be filled later)*

---

### **Example:**

**Input:** `"abcabcbb"`

We want to find the length of the longest substring with **no repeating characters**.

**Expected Output:** `3` (for substring `"abc"`)

---

### **Step-by-Step Visualization**

| Iteration | Current Character | Current Substring | Max Length So Far |
| --------- | ----------------- | ----------------- | ----------------- |
| 0         | a                 | "a"               | 1                 |
| 1         | b                 | "ab"              | 2                 |
| 2         | c                 | "abc"             | 3                 |
| 3         | a                 | "bca"             | 3                 |
| 4         | b                 | "cab"             | 3                 |
| 5         | c                 | "abc"             | 3                 |
| 6         | b                 | "cb"              | 3                 |
| 7         | b                 | "b"               | 3                 |

---

### **Visual Diagram**

```
Step 0: "" → add 'a' → "a" → max 1
Step 1: "a" → add 'b' → "ab" → max 2
Step 2: "ab" → add 'c' → "abc" → max 3
Step 3: "abc" → 'a' repeats → slide window → "bca" → max 3
...
```

---

### 🤔 Why I Chose This Approach

---

### 📈 Time & Space Complexity

* **Time Complexity**:
* **Space Complexity**:

---

### ✅ Final Thoughts / Learnings
