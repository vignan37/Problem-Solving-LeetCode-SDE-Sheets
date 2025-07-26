class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        int count = 0;

        for (int i = 0; i < length; i++) {
            // Only try to plant at empty plots
            if (flowerbed[i] == 0) {
                // Check if left neighbor is empty or if this is the first plot
                boolean emptyLeft = (i == 0) || (flowerbed[i - 1] == 0);

                // Check if right neighbor is empty or if this is the last plot
                boolean emptyRight = (i == length - 1) || (flowerbed[i + 1] == 0);

                // If both neighbors are empty, plant a flower here
                if (emptyLeft && emptyRight) {
                    flowerbed[i] = 1; // Mark the spot as planted
                    count++;          // Increment the count of planted flowers

                    // If we've planted enough flowers, return true early
                    if (count >= n) return true;
                }
            }
        }

        // After traversing, check if we planted at least n flowers
        return count >= n;
    }
}


/*

This is part of LC blind 75

https://leetcode.com/problems/can-place-flowers

 605. Can Place Flowers

You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

 

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
 

Constraints:

1 <= flowerbed.length <= 2 * 104
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
0 <= n <= flowerbed.length
 */