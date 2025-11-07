/*
==========================================
🧩 Problem: Two Sum (LeetCode #1)
------------------------------------------
Given an array of integers nums and an integer target, 
return indices of the two numbers such that they add up to target.

🕒 Time Complexity: O(n²)
💾 Space Complexity: O(1)
🧠 Difficulty: Easy
==========================================
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (j != i && nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}

/*
🧾 Notes:
✔ This is the brute-force approach.
✔ It checks every possible pair → O(n²) time.
✔ Works fine for small inputs, but inefficient for large arrays.
✔ Can be optimized using a HashMap for O(n) time.
*/
