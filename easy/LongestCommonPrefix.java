/*
==========================================
Problem: Longest Common Prefix (LeetCode #14)
------------------------------------------
Write a function to find the longest common prefix string 
among an array of strings. If there is no common prefix, return "".

Time Complexity:
- Approach 1: O(N * M)  → N = number of strings, M = length of shortest string
- Approach 2: O(N * M)
Space Complexity: O(1)
Difficulty: Easy
------------------------------------------
Approach 1: Character-by-Character Comparison
Approach 2: Prefix Reduction Using indexOf
==========================================
*/

public class LongestCommonPrefix {

    // Approach 1: Character-by-Character Comparison
    public String longestCommonPrefix_CharCompare(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /*
    Explanation:
    - Compare characters at the same index across all strings.
    - Stop when any mismatch or string-end is found.
    - Fast and intuitive, great for interview coding rounds.
    */


    // Approach 2: Prefix Reduction
    public String longestCommonPrefix_PrefixReduce(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        String prefix = strs[0];
        for (String s : strs) {
            while (s.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    /*
    Explanation:
    - Start with the first string as prefix.
    - Gradually shorten it until all strings start with it.
    - Slightly slower for very large inputs but compact and clean.
    */


    // Optional test for VS Code
    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();

        String[] words1 = {"flower", "flow", "flight"};
        String[] words2 = {"dog", "racecar", "car"};

        System.out.println("Approach 1 Output (Set 1): " + obj.longestCommonPrefix_CharCompare(words1));
        System.out.println("Approach 2 Output (Set 1): " + obj.longestCommonPrefix_PrefixReduce(words1));

        System.out.println("Approach 1 Output (Set 2): " + obj.longestCommonPrefix_CharCompare(words2));
        System.out.println("Approach 2 Output (Set 2): " + obj.longestCommonPrefix_PrefixReduce(words2));
    }
}

/*
Example:
Input: ["flower", "flow", "flight"]
Output: "fl"

Input: ["dog", "racecar", "car"]
Output: ""

------------------------------------------
Approach 1: Best for clarity and speed.
Approach 2: Best for concise coding style.
*/
