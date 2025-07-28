
/*optimized approach o(n) time and o(1) space
 Zeros in the array decide the final output
 1. if there are more than two zeros in the array, then everything will be 0.
    [1,0,3,0,4] -> [0,0,0,0]
 2. if no zeros in array then we can easily get it by doing product / iValue.
    [1,2,3,4] -> [24,12,8,6]
 3. if 1 zero then that index will have product , rest zeros 
    [-1,1,0,-3,3] -> [0,0,9,0,0]
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product=1;
        int zerosCount=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                zerosCount++;
            }
            else product = product * nums[i];
        }
        if(zerosCount==0){
            for (int i = 0; i < nums.length; i++) {
                nums[i]=product/nums[i];
            }
        }
        else if(zerosCount>1){
            for (int i = 0; i < nums.length; i++) {
                nums[i]=0;
            }
        }
        else{
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]==0){
                    nums[i]=product;
                }
                else nums[i]=0;
            }
        }
        return nums;
    }
}

// Post fix and prefix product array approach o(n) time and o(n) space

/*
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int product=1;
        for (int i = 0; i < nums.length; i++) {
            product = product * nums[i];
            prefix[i]=product;
        }
        product=1;
        for (int i = nums.length-1; i>=0; i--) {
            product = product * nums[i];
            postfix[i]=product;
        }
        
        
        for (int i = 0; i < nums.length; i++) {
            System.out.println(prefix[i]);
            if(i==0){
                nums[i]=postfix[i+1];
            }
            else if(i+1==nums.length){
                nums[i]= prefix[i-1];
            }
            else nums[i] = prefix[i-1] * postfix[i+1];
        }
        
        return nums;
    }
}
/*

/*
Brute Force Clean O(n2)
if i & j are not equal then build product and set
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    product *= nums[j];
                }
            }
            answer[i] = product;
        }
        
        return answer;
    }
}
    
*/

/*
Brute Force 1: O (n2)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int answer[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int tp=1;
            for(int j=0;j<nums.length;j++){
                if(j==0){
                    if(i==0){
                        continue;
                    }
                    else{
                        tp=nums[j];
                        continue;
                    } 
                }
                if(j==1 && i==0){
                    tp=nums[j];
                    continue;
                }
                else{
                    if(i!=j){
                        tp = tp * nums[j];
                    }
                } 
            }
            answer[i]=tp;
        }
        return answer;
    }
}
*/




/*
 
238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */