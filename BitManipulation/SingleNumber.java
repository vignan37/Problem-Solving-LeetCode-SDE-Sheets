class Solution {

    public int singleNumber(int[] nums) {
        // Observation:
        // Every element appears twice except one.
        // We need O(n) time and O(1) extra space.

        // XOR properties:
        // 1. a ^ a = 0  (duplicates cancel each other)
        // 2. a ^ 0 = a  (unique number remains)
        // 3. XOR is commutative and associative,
        //    so the order of elements doesn't matter.
        // XOR all elements.
        // Every duplicate pair cancels out,
        // leaving only the element that appears once.
        int ans = 0;

        for (int num : nums) {
            ans = num ^ ans;
        }

        return ans;
    }
}

/*
 * 
 * - Q
 * 
 * <aside>
 * 3️⃣
 * 
 * # **136. Single Number**
 * 
 * Given a **non-empty** array of integers `nums`, every element appears *twice*
 * except for one. Find that single one.
 * 
 * You must implement a solution with a linear runtime complexity and use only
 * constant extra space.
 ** 
 * Example 1:**
 ** 
 * Input:** nums = [2,2,1]
 ** 
 * Output:** 1
 ** 
 * Example 2:**
 ** 
 * Input:** nums = [4,1,2,1,2]
 ** 
 * Output:** 4
 ** 
 * Example 3:**
 ** 
 * Input:** nums = [1]
 ** 
 * Output:** 1
 ** 
 * Constraints:**
 * 
 * - `1 <= nums.length <= 3 * 104`
 * - `3 * 104 <= nums[i] <= 3 * 104`
 * - Each element in the array appears twice except for one element which
 * appears only once.
 * </aside>
 * 
 * 
 */
