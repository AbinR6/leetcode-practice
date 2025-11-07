/*
==========================================
Problem: Add Binary (LeetCode #67)
------------------------------------------
Given two binary strings a and b, return their sum as a binary string.

Time Complexity: O(max(n, m))
Space Complexity: O(max(n, m))
Difficulty: Easy
------------------------------------------
Approach: Bitwise Simulation using StringBuilder
==========================================
*/

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;  // pointer for string a
        int j = b.length() - 1;  // pointer for string b
        int carry = 0;           // carry from previous addition

        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';  // convert char to int (0 or 1)
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            carry = sum / 2;               // calculate carry
            result.append(sum % 2);        // append remainder (binary bit)
        }

        // Reverse because we build from LSB to MSB
        return result.reverse().toString();
    }
}

/*
Explanation:
- Works like manual binary addition (from right to left).
- Keep adding bits with carry until both strings and carry are processed.
- Uses StringBuilder for efficient concatenation.

Example:
Input:  a = "1010", b = "1011"
Process:
    1010
  + 1011
  ------
   10101
Output: "10101"

------------------------------------------
- Clean, optimal, and handles all edge cases.
- No extra data structures beyond StringBuilder.
*/
