
// Math.max is same in java and in JS.
// This is a Sliding window Q & using while loop simplifies things and has more control over i & js
class Solution {
    maximumSumSubarray(arr, k) {
        // code here
        let max= 0;
        let currSum =0;
        let j=0,i=0;
        while(j<arr.length){
            currSum += arr[j];
            //move j till u reach window
            if(j-i+1<k){
                j++;
            }
            //once you got the window check max , remove old i and then inc i and j
            else if(j-i+1==k){
                //same in js and in java
                max = Math.max(max,currSum);
                currSum -= arr[i];
                i++;
                j++;
            }
            
        }
    
        return max;
    }
}

// This is the basic gfg question for Sliding window.
/*
class Solution {
    maximumSumSubarray(arr, k) {
        // code here
        let max= 0;
        let currentWindowSum =0;
        for(let i=0, j =0;i<arr.length;i++){
            if(i==0){
                while(j-i+1<=k){
               currentWindowSum= currentWindowSum+arr[j];
                j++;
                }
                max = currentWindowSum;
            }
            else if(j-i+1==k){
                currentWindowSum = currentWindowSum + arr[j] - arr[i-1];
                if(currentWindowSum>max){
                    max = currentWindowSum;
                }
                j++;
            }
            
        }
        return max;
    }
}
*/

/*
https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

Max Sum Subarray of size K
Difficulty: EasyAccuracy: 49.6%Submissions: 203K+Points: 2
Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.

Note: A subarray is a contiguous part of any given array.

Examples:

Input: arr[] = [100, 200, 300, 400] , k = 2
Output: 700
Explanation: arr3  + arr4 = 700, which is maximum.
Input: arr[] = [100, 200, 300, 400] , k = 4
Output: 1000
Explanation: arr1 + arr2 + arr3 + arr4 = 1000, which is maximum.
Input: arr[] = [100, 200, 300, 400] , k = 1
Output: 400
Explanation: arr4 = 400, which is maximum.
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 106
1 ≤ k ≤ arr.size()

*/