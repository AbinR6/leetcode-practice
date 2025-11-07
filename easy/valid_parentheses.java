/*
==========================================
Problem: Valid Parentheses (LeetCode #20)
------------------------------------------
Given a string s containing just the characters 
'(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

An input string is valid if:
1. Open brackets are closed by the same type of brackets.
2. Open brackets are closed in the correct order.

Time Complexity: O(n)
Space Complexity: O(n)
Difficulty: Easy
------------------------------------------
Approach 1: Stack-Based Matching (Optimal)
Approach 2: Replace Pairs Until Stable (Alternative)
==========================================
*/

import java.util.Stack;

class ValidParentheses {

    // Approach 1: Stack-Based Matching
    boolean isValid_Stack(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push opening brackets
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If stack empty or mismatch, invalid
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Stack should be empty if all brackets matched
        return stack.isEmpty();
    }

    /*
    Explanation:
    - Push all opening brackets to stack.
    - Pop and compare when a closing bracket appears.
    - If mismatch or stack underflow → invalid.
    - Linear time, uses O(n) auxiliary space.
    */


    // Approach 2: Replace Pairs Until String is Empty
    boolean isValid_Replace(String s) {
        int len;
        do {
            len = s.length();
            s = s.replace("()", "")
                 .replace("{}", "")
                 .replace("[]", "");
        } while (s.length() != len);
        return s.isEmpty();
    }

    /*
    Explanation:
    - Repeatedly remove valid pairs "()", "{}", and "[]" until stable.
    - If nothing remains, it was valid; else invalid.
    - Simple but less efficient due to repeated string replacements.
    */


    // Main method for quick testing
    public static void main(String[] args) {
        ValidParentheses obj = new ValidParentheses();

        String[] tests = {"()", "()[]{}", "(]", "([)]", "{[]}", "(((", ""};

        System.out.println("Approach 1: Stack-based Validation");
        for (String s : tests) {
            System.out.println("Input: " + s + " → " + obj.isValid_Stack(s));
        }

        System.out.println("\nApproach 2: Replacement-based Validation");
        for (String s : tests) {
            System.out.println("Input: " + s + " → " + obj.isValid_Replace(s));
        }
    }
}

/*
Example:
Input: "()[]{}" → true  
Input: "([)]"   → false  
Input: "{[]}"   → true  

------------------------------------------
Approach 1: Best for performance and clarity.
Approach 2: Simpler but slower (good for small inputs).
*/
