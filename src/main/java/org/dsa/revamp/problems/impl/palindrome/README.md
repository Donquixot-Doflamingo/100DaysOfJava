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

> *(You will write your code solution here)*

```
// Your implementation goes here
```

---

### 🧠 Implementation Logic

> *(Explain the steps your solution follows — without inserting the actual code)*

---

### 🤔 Why I Chose This Approach

> *(Mention why you picked your logic — efficiency, readability, constraints handling, etc.)*

---

### 📈 Time & Space Complexity

> *(Document the complexity after writing your solution)*

---

### ✅ Final Thoughts / Learnings

> *(Add insights or challenges you noticed while solving)*