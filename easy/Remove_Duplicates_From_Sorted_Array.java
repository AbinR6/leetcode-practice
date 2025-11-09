/*
==========================================
Problem: Remove Duplicates from Sorted Array (LeetCode #26)
------------------------------------------
Given a sorted array nums, remove the duplicates in-place such that 
each element appears only once and return the new length.

Do not allocate extra space for another array — 
you must do this by modifying the input array in-place.

Time Complexity: O(n)
Space Complexity: O(1)
Difficulty: Easy
==========================================
*/

// Approach: Two-Pointer Technique (In-Place)
public class Remove_Duplicates_From_Sorted_Array {
    public int removeDuplicates(int[] nums) 
    {
        // Edge case: null or empty array
        if (nums == null || nums.length == 0) 
        {
            return 0;
        }
        
        // i: pointer to last unique element's index
        int i = 0;  
        
        // j: pointer scanning through the array
        for (int j = 1; j < nums.length; j++) 
        {
            // When a new unique element is found
            if (nums[j] != nums[i]) 
            {
                i++;               // Move unique boundary
                nums[i] = nums[j]; // Place new unique element
            }
        }
        
        // i + 1 gives total count of unique elements
        return i + 1;
    }
}

/*
Explanation:
- This method works on sorted arrays.
- The pointer i keeps track of the end of the unique portion.
- The pointer j scans ahead to find new unique values.
- Each new unique value is placed right after the last one found.
- The array is modified in-place, no extra memory used.
*/


/*
Example:
Input:  [0,0,1,1,1,2,2,3,3,4]
Output: 5
Array after processing: [0,1,2,3,4,_,_,_,_,_]
*/


/*
Notes:
- Works only on sorted arrays.
- If array is unsorted, sort first or use a Set-based approach.
- Commonly tested problem to demonstrate two-pointer mastery.
*/
