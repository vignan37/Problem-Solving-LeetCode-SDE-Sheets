/*
Two pointers (i & j) → define a sliding window.
onesCount → tracks current window size.
tempK → available zero flips left in the current window.

When nums[j] == 1 → just extend window.When nums[j] == 0:
• If tempK > 0 → flip it & extend.
• Else → shrink from left until a flip is freed.
Update maxOnes every time window grows.
Time O(n), Space O(1) → efficient sliding window.
*/
class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0;        // i = left pointer, j = right pointer for sliding window
        int onesCount = 0;       // current window size (including flipped zeros)
        int maxOnes = 0;         // answer (max window size found so far)
        int tempK = k;           // remaining flips available in current window

        // Expand window by moving 'j'
        while (j < nums.length) {
            
            // Case 1: Current element is 1 → just extend window
            if (nums[j] == 1) {
                onesCount++;  // increase window size
                maxOnes = Math.max(onesCount, maxOnes); // update result if bigger window found
                j++;          // move right pointer
            } 
            
            // Case 2: Current element is 0
            else if (nums[j] == 0) {
                
                // If we still have flips available → flip this zero
                if (tempK > 0) {
                    onesCount++;  // include flipped zero in window
                    tempK--;      // use one flip
                    maxOnes = Math.max(onesCount, maxOnes);
                    j++;          // move right pointer
                } 
                
                // No flips left → shrink window from left until we free a zero
                else {
                    if (nums[i] == 0) tempK++; // if left element was flipped zero, restore flip
                    onesCount--;   // shrink window
                    i++;           // move left pointer
                }
            }
        }
        
        return maxOnes; // max consecutive ones with at most k flips
    }
}
/*
# [**1004. Max Consecutive Ones III**](https://leetcode.com/problems/max-consecutive-ones-iii/)

Given a binary array `nums` and an integer `k`, return *the maximum number of consecutive* `1`*'s in the array if you can flip at most* `k` `0`'s.

**Example 1:**

```
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
```

**Example 2:**

```
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

```

**Constraints:**

- `1 <= nums.length <= 105`
- `nums[i]` is either `0` or `1`.
- `0 <= k <= nums.length`
 */