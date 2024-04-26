class Solution {
    
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum =0;
        for(int i =0;i<n;i++){
            sum = sum + nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        else{
            return subSetSum(nums, sum/2);
        }
    }

    public boolean subSetSum(int[] nums, int sum){
        int n = nums.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int j=0;j<sum+1;j++){
            dp[0][j] = false;
        }
        for(int i=0;i<n+1;i++){
            dp[i][0] = true;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(nums[i-1]<=j){
                    dp[i][j] =dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}



/*
416. Partition Equal Subset Sum : Coding ninjas
Solved
Medium
Topics
Companies
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
*/
