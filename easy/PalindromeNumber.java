/*
==========================================
Problem: Palindrome Number (LeetCode #9)
------------------------------------------
Given an integer x, return true if x is a palindrome, and false otherwise.

A palindrome is a number that reads the same backward as forward.

Time Complexity: O(log₁₀(n)) — we process half the digits
Space Complexity: O(1)
Difficulty: Easy
------------------------------------------
Approach Used: Reverse Half of the Number
==========================================
*/

public class PalindromeNumber {

    // Approach: Reverse Half of the Number
    public boolean isPalindrome(int x) {
        // Negative numbers and multiples of 10 (except 0) cannot be palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int rev = 0;

        // Reverse only half of the number
        while (x > rev) {
            rev = (rev * 10) + (x % 10);
            x = x / 10;
        }

        // For odd-length numbers, ignore the middle digit (rev/10)
        return x == rev || x == rev / 10;
    }

    // Optional main method for quick testing
    public static void main(String[] args) {
        PalindromeNumber obj = new PalindromeNumber();

        System.out.println("Input: 121  → Output: " + obj.isPalindrome(121));
        System.out.println("Input: -121 → Output: " + obj.isPalindrome(-121));
        System.out.println("Input: 10   → Output: " + obj.isPalindrome(10));
        System.out.println("Input: 1221 → Output: " + obj.isPalindrome(1221));
    }
}

/*
Explanation:
- This approach reverses only half of the number to save time.
- Avoids overflow issues caused by full reversal.
- Works in O(log n) time since we divide the number each loop.
- Cleaner and faster than string conversion methods.

Example:
Input:  x = 121
rev = 121 → returns true

Input:  x = -121
returns false

Input:  x = 10
returns false
*/
