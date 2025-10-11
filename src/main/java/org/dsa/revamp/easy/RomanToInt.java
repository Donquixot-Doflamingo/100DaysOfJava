package org.dsa.revamp.easy;

public class RomanToInt {
    // TIP: Instead of going from left to right solve it right to left
    public int solution(String s) {
        // Convert the string into a character array so we can loop through each Roman numeral
        char[] arr = s.toCharArray();

        int num = 0;  // This will temporarily store the value of each Roman numeral
        int ans = 0;  // This is our running total (final answer)

        // Start from the end of the Roman numeral string and move backwards
        for (int i = s.length() - 1; i >= 0; i--) {

            // Convert the current Roman numeral character to its corresponding value
            num = switch (arr[i]) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> num;
            };

            // Here's the tricky part:
            // If the current value is smaller than a value we've already added (like I before V),
            // we subtract it instead of adding. This handles cases like IV (4), IX (9), etc.
            // The "num * 4 < ans" trick is a shortcut to detect if this should be subtraction.
            // It's not an exact formula but works reliably for Roman numeral patterns.
            if (num * 4 < ans) {
                ans -= num;  // Subtract if it's a subtractive case
            } else {
                ans += num;  // Otherwise, just add it normally
            }
        }

        // After looping through all characters, we have our total value
        return ans;
    }
}
