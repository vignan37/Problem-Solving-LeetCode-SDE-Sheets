/* 31. Next Permutation

A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.
*/


class Solution {

    static void reverse(int arr[], int start,int end){
        
        while(start<end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }

    static void swap(int arr[], int start, int end){
        int temp= arr[end];
        arr[end]=arr[start];
        arr[start]=temp;
    }


    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length<=1) return;
        int index1=-1;
        int index2 =-1;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                index1=i-1;
                break;
            }
        }
        if(index1!=-1){

            for(int i=nums.length-1;i>index1;i--){
                if(nums[index1]<nums[i]){
                    index2=i;
                    break;
                }
            }

            swap(nums,index1,index2);
            reverse(nums,index1+1,nums.length-1);
        }

        else reverse(nums,0,nums.length-1);
    }
}
