/*
==========================================
Problem: Roman to Integer (LeetCode #13)
------------------------------------------
Given a Roman numeral, convert it to an integer.

Roman numerals are represented by seven symbols:
I, V, X, L, C, D, and M.

Time Complexity: O(n)
Space Complexity: O(1)
Difficulty: Easy
------------------------------------------
Approach 1: HashMap Lookup
Approach 2: Switch Expression (Modern Rule Switch)
==========================================
*/

import java.util.*;

public class RomanToInteger {

    // Approach 1: Using HashMap
    public int romanToInt_HashMap(String s) {
        Map<Character, Integer> rm = new HashMap<>();
        rm.put('I', 1);
        rm.put('V', 5);
        rm.put('X', 10);
        rm.put('L', 50);
        rm.put('C', 100);
        rm.put('D', 500);
        rm.put('M', 1000);

        int total = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int current = rm.get(s.charAt(i));
            if (current < prev)
                total -= current;
            else
                total += current;
            prev = current;
        }

        return total;
    }

    /*
    Explanation:
    - Traverses the string from right to left.
    - Subtracts a numeral if it’s smaller than the one after it.
    - Otherwise, adds it to the total.
    - Simple and intuitive, but requires a small HashMap lookup each time.
    */


    // Approach 2: Using Rule Switch (Modern Java)
    public int romanToInt_Switch(String s) {   
        int ans = 0, num ;

        for (int i = s.length() - 1; i >= 0; i--) {
            num = switch (s.charAt(i)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };

            ans += (4 * num < ans) ? -num : num;
        }
        return ans;
    }

    /*
    Explanation:
    - Uses Java's modern rule switch expression (Java 14+).
    - Each case returns a value directly using '->' syntax.
    - More concise, avoids fall-through errors, and is safer.
    */


    // Optional main() for quick testing
    public static void main(String[] args) {
        RomanToInteger obj = new RomanToInteger();

        String input1 = "III";
        String input2 = "LVIII";
        String input3 = "MCMXCIV";

        System.out.println("Input: " + input1 + " → Output (HashMap): " + obj.romanToInt_HashMap(input1));
        System.out.println("Input: " + input1 + " → Output (Switch): " + obj.romanToInt_Switch(input1));

        System.out.println("Input: " + input2 + " → Output (HashMap): " + obj.romanToInt_HashMap(input2));
        System.out.println("Input: " + input2 + " → Output (Switch): " + obj.romanToInt_Switch(input2));

        System.out.println("Input: " + input3 + " → Output (HashMap): " + obj.romanToInt_HashMap(input3));
        System.out.println("Input: " + input3 + " → Output (Switch): " + obj.romanToInt_Switch(input3));
    }
}

/*
Example:
Input: "MCMXCIV"
Process:
M (1000) → +1000
C (100) < previous (1000) → -100
M (1000) → +1000
X (10) < previous (100) → -10
C (100) → +100
I (1) < previous (5) → -1
V (5) → +5
Total = 1994
*/
