class Solution {
    public int[] countBits(int n) {

        // DP: There is a relationship between the answers.
        // Right shift (i >> 1) removes the last binary bit,
        // which is equivalent to dividing by 2.

        int dp[] = new int[n + 1];
        dp[0] = 0; // Base case: 0 has zero set bits.

        for (int i = 1; i <= n; i++) {

            if (i % 2 == 0) {
                // EVEN: Last binary bit is 0.
                // Removing it doesn't change the number of set bits.
                // dp[i] = dp[i >> 1];
                dp[i] = dp[i / 2];
            } else {
                // ODD: Last binary bit is 1.
                // Removing it decreases the set-bit count by 1.
                // dp[i] = dp[i >> 1] + 1;
                dp[i] = dp[i / 2] + 1;
            }
        }

        return dp;
    }
}

/*
 * 
 * - Q
 * 
 * # 338. Counting Bits
 ** 
 * Problem:** Given an integer `n`, return an array `ans` of size `n + 1`, where
 * `ans[i]` contains the number of `1`s in the binary representation of `i`.
 ** 
 * Example:**
 * 
 * Input: `n = 5`
 * 
 * | Number (i) | Binary | Number of 1s (`ans[i]`) |
 * | --- | --- | --- |
 * | 0 | `0` | 0 |
 * | 1 | `1` | 1 |
 * | 2 | `10` | 1 |
 * | 3 | `11` | 2 |
 * | 4 | `100` | 1 |
 * | 5 | `101` | 2 |
 ** 
 * Output:** `[0, 1, 1, 2, 1, 2]`
 ** 
 * Note:** Each array index represents a number, and its value represents the
 * count of set bits in that number.
 ** 
 * Follow-up:** Can you solve it in O(n) time without using built-in
 * bit-counting functions?
 * 
 * # **338. Counting Bits**
 * 
 * Given an integer `n`, return *an array* `ans` *of length* `n + 1` *such that
 * for each* `i` **(`0 <= i <= n`)*,* `ans[i]` *is the **number of*** `1`***'s**
 * in the binary representation of* `i`.
 * 
 * Do not solve it with built-in functions (i.e., like __builtin_popcount in
 * C++).
 ** 
 * Example 1:**
 * 
 * ```
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * ```
 ** 
 * Example 2:**
 * 
 * ```
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * ```
 ** 
 * Constraints:**
 * 
 * - `0 <= n <= 105`
 ** 
 * Follow up:**
 * 
 * - It is very easy to come up with a solution with a runtime of `O(n log n)`.
 * Can you do it in linear time `O(n)` and possibly in a single pass?
 * 
 */