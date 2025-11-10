/*
==========================================
Problem: Remove Element (LeetCode #27)
------------------------------------------
Given an integer array nums and an integer val, 
remove all occurrences of val in-place. 
The order of the elements may be changed. 
Then return the number of elements in nums which are not equal to val.

Time Complexity: O(n)
Space Complexity: O(1)
Difficulty: Easy
==========================================
*/

// Approach: Two-Pointer Replacement (In-place Removal)
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;

        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];  // Replace current with last valid element
                n--;                    // Reduce the effective array size
            } else {
                i++;                    // Move to next element
            }
        }

        return n;  // New length after removal
    }
}

/*
Explanation:
- Iterate through the array with index i.
- Whenever nums[i] equals val, replace it with the last valid element (nums[n - 1]) and decrease n.
- This effectively discards the matched element while maintaining O(1) space.
- The loop ends when i reaches the reduced array length.
*/

/*
Notes:
- This method is optimal when element order does not matter.
- It performs all operations in-place using constant memory.
- Ideal for interview scenarios emphasizing space efficiency.
*/
