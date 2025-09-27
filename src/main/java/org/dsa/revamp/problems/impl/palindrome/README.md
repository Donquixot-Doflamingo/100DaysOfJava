## 🧩 Problem 1: Valid Palindrome

### ✅ Problem Statement

You are given a string, and the goal is to determine whether it reads the same forward and backward **after** removing all non-alphanumeric characters and ignoring letter casing.

You must evaluate the string based on:

* Only **letters and digits**
* **Case-insensitive comparison**
* Characters like spaces, punctuation, and symbols should be ignored

The output is typically a **boolean** indicating whether the cleaned string is a palindrome.

---

### ⚠️ Constraints & Limitations

* **Non-Alphanumeric Characters**: Ignoring punctuation, spaces, and symbols is mandatory.
* **Case Sensitivity**: Comparisons must treat uppercase and lowercase letters as the same.
* **Empty String Case**: An empty or single-character string is generally considered valid.
* **Unicode Characters**: Some platforms assume ASCII; others may require handling extended characters.
* **String Length**: Large strings may demand optimized approaches to avoid unnecessary overhead.
* **Memory Usage**: Choices like creating reversed copies vs. two-pointer techniques impact space complexity.

---

### ✅ Input Examples (Without Solutions)

| Input                            | Expected Output                        | Why This Is Important                                |
| -------------------------------- |----------------------------------------|------------------------------------------------------|
| "A man, a plan, a canal: Panama" | true                                   |                                                      |
| "race a car"                     | false                                  |                                                      |
| " "                              | true                                   |                                                      |
| "0P"                             | false                                  |                                                      |
| ""                             | true                                   | Empty strings should be valid                        |
| ".,,"                          | true                                   | Only punctuation → becomes empty → valid             |
| "a"                            | true                                   | Single-character strings are palindromes             |
| "ab"                           | false                                  | Basic non-palindrome check                           |
| "Able was I, ere I saw Elba!"  | true                                   | Mixed case + punctuation                             |
| "No 'x' in Nixon"              | true                                   | Apostrophes, spaces, casing                          |
| "12321"                        | true                                   | Numeric palindrome                                   |
| "1231"                         | false                                  | Numeric non-palindrome                               |
| "0P"                           | false                                  | Mixed digit and char edge case                       |
| "😊abba😊"                     | true/false (depends on rules)          | Emojis should likely be ignored or handled carefully |
| "🧡a🧡"                        | true/false                             | Non-alphanumeric unicode characters                  |
| "aa😊"                         | true                                   | Some solutions may fail ignoring emoji               |
| "a😊a"                         | true                                   | Ignoring emoji in between                            |
| "Madam In Eden, I’m Adam"      | true                                   | Spaces, punctuation, case                            |
| "Was it a car or a cat I saw?" | true                                   | Long string with symbols                             |
| "  "                           | true                                   | Only spaces → becomes empty                          |
| "Àbba"                         | true/false (depends on implementation) | Unicode accents — may need normalization             |
| "Ésope reste ici et se repose" | true                                   | French palindrome with accents                       |
| "abaZ"                         | false                                  | Wrong ending                                         |
| "ZZZzzz"                       | true                                   | Same letters, different case                         |


---

### ✏️ My Solution (Code)

```
@Override
public Boolean solveProblem(String input) {
    if (StringUtils.isEmpty(input) || input.length() == 1) {
        return true;
    }
    int i = 0, j = input.length() - 1;
    while (i < j) {
        // Move i to the next alphanumeric character
        while (i < j && !Character.isLetterOrDigit(input.charAt(i))) i++;
        // Move j to the previous alphanumeric character
        while (i < j && !Character.isLetterOrDigit(input.charAt(j))) j--;

        if (Character.toLowerCase(input.charAt(i)) != Character.toLowerCase(input.charAt(j))) {
            return false;
        }
        i++;
        j--;
    }
    return true;
}
```

---

### 🧠 Implementation Logic

1. Use **two pointers**: `i` at the start, `j` at the end of the string.
2. **Skip non-alphanumeric characters**: Move `i` forward and `j` backward until they point to valid characters.
3. **Compare characters**: Convert both to lowercase and check equality. If they differ, return `false`.
4. **Move pointers**: Increment `i` and decrement `j` and repeat.
5. **Return `true`**: If the loop finishes without mismatches, the string is a palindrome.

---

### 🤔 Why I Chose This Approach

- **Efficiency**: No need to create a new string with `replaceAll`.
- **Simplicity**: Single pass with a clear while-loop logic.
- **Optimal for interviews**: O(n) time and O(1) space.
- **Edge-case friendly**: Works for empty strings, single-character strings, and strings with only special characters.

---

### 📈 Time & Space Complexity

| Metric             | Complexity | Explanation                                                                                                                            |
|-------------------|------------|----------------------------------------------------------------------------------------------------------------------------------------|
| **Time Complexity** | O(n)       | Each character is visited at most once by the two pointers. Skipping non-alphanumeric characters doesn’t change the linear complexity. |
| **Space Complexity** | O(1)       | Only two pointers and temporary variables are used. No extra strings or data structures are created.                                   |


---

### ✅ Final Thoughts / Learnings

- **Two-pointer technique is powerful**: Ideal for symmetric comparison problems like palindromes.
- **In-place processing saves memory**: Avoid extra strings or arrays.
- **Reliable character validation**: Use `Character.isLetterOrDigit()` to filter unwanted characters.
- **Consider edge cases**: Empty strings, single characters, and strings with only special characters.

✅ Overall, this approach is clean, efficient, and widely accepted for coding interviews like LeetCode.
