
// difference Array Technique
class Solution {
    public int maximumPopulation(int[][] logs) {

        int diff[] = new int[2051];

        // set the values in the array
        for (int[] log : logs) {
            diff[log[0]] += 1;
            diff[log[1]] -= 1;
        }

        // calculate the cumilative and update the max population
        int cumilative = 0;
        int maxPopulationYear = Integer.MIN_VALUE;
        int maxPopulation = 0;
        for (int i = 1950; i < 2051; i++) {
            diff[i] += diff[i - 1];
            if (diff[i] > maxPopulation) {
                maxPopulation = diff[i];
                maxPopulationYear = i;
                System.out.println(" " + maxPopulationYear + " " + maxPopulation);
            }
        }
        System.out.println(diff[2025]);
        return maxPopulationYear;
    }
}

/*
 * 
 * - Q
 * 
 * # **1854. Maximum Population Year**
 * 
 * Solved
 * 
 * Easy
 * 
 * Topics
 * 
 * !premium lock icon
 * 
 * Companies
 * 
 * Hint
 * 
 * You are given a 2D integer array `logs` where each `logs[i] = [birthi,
 * deathi]` indicates the birth and death years of the `ith` person.
 * 
 * The **population** of some year `x` is the number of people alive during that
 * year. The `ith` person is counted in year `x`'s population if `x` is in
 * the **inclusive** range `[birthi, deathi - 1]`. Note that the person
 * is **not** counted in the year that they die.
 * 
 * Return *the **earliest** year with the **maximum population***.
 ** 
 * Example 1:**
 * 
 * ```
 * Input: logs = [[1993,1999],[2000,2010]]
 * Output: 1993
 * Explanation: The maximum population is 1, and 1993 is the earliest year with
 * this population.
 * ```
 ** 
 * Example 2:**
 * 
 * ```
 * Input: logs = [[1950,1961],[1960,1971],[1970,1981]]
 * Output: 1960
 * Explanation:
 * The maximum population is 2, and it had happened in years 1960 and 1970.
 * The earlier year between them is 1960.
 * ```
 ** 
 * Constraints:**
 * 
 * - `1 <= logs.length <= 100`
 * - `1950 <= birthi < deathi <= 2050`
 * 
 */