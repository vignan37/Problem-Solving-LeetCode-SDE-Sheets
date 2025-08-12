//clean approach:
/*
class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0, j = 0, zeroCount = 0, max = 0;

        while (j < nums.length) {
            // Include nums[j] in window
            if (nums[j] == 0) zeroCount++;

            // Shrink window if more than 1 zero
            while (zeroCount > 1) {
                if (nums[i] == 0) zeroCount--;
                i++;
            }

            // j - i because we delete one element
            max = Math.max(max, j - i);
            j++;
        }

        return max;
    }
}
*/

//My way

class Solution {
    public int longestSubarray(int[] nums) {
        int i=0,j=0,zeroCount=1,max=0;
        while(j<nums.length){
            if(nums[j]==1){
                max = Math.max(j-i,max);
                j++;
            }
            else if(nums[j]==0){
                if(zeroCount==1){
                    max = Math.max(j-i,max);
                    zeroCount--;
                    j++;
                }
                else{
                    while(nums[i]!=0){
                        i++;
                    }
                    i++;
                    zeroCount=1;
                }
            }
        }
        return max;
        
    }
}

/*
- Q
    
    # [**1493. Longest Subarray of 1's After Deleting One Element**](https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/)
    
    Given a binary array `nums`, you should delete one element from it.
    
    Return *the size of the longest non-empty subarray containing only* `1`*'s in the resulting array*. Return `0` if there is no such subarray.
    
    **Example 1:**
    
    ```
    Input: nums = [1,1,0,1]
    Output: 3
    Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
    
    ```
    
    **Example 2:**
    
    ```
    Input: nums = [0,1,1,1,0,1,1,0,1]
    Output: 5
    Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
    
    ```
    
    **Example 3:**
    
    ```
    Input: nums = [1,1,1]
    Output: 2
    Explanation: You must delete one element.
    
    ```
    
    **Constraints:**
    
    - `1 <= nums.length <= 105`
    - `nums[i]` is either `0` or `1`.
    */