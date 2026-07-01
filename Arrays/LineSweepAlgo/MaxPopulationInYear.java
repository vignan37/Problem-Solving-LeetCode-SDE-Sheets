// line sweep algorithm
/*
class Solution {
    public int maximumPopulation(int[][] logs) {

        // Each log creates 2 events:
        // Birth  -> +1
        // Death  -> -1
        int[][] events = new int[logs.length * 2][2];

        int idx = 0;
        for (int[] log : logs) {
            // Birth event
            events[idx][0] = log[0];
            events[idx][1] = 1;
            idx++;

            // Death event
            events[idx][0] = log[1];
            events[idx][1] = -1;
            idx++;
        }

        // Sort by year.
        // If same year, process death (-1) before birth (+1)
        Arrays.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1]; // -1 comes before +1
        });

        int currentPopulation = 0;
        int maxPopulation = 0;
        int answer = 1950;

        for (int[] event : events) {

            currentPopulation += event[1];

            if (currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                answer = event[0];
            }
        }

        return answer;
    }
}
*/

// difference Array Technique
class Solution {
    public int maximumPopulation(int[][] logs) {
        
        int[] year = new int[2051];
        
		// O(n) -> n is log.length
		
        for(int[] log : logs){
            
            year[log[0]] += 1;
            year[log[1]] -= 1;
        }
        
        int maxNum = year[1950], maxYear = 1950;
        
		// O(100) -> 2050 - 1950 = 100

        for(int i = 1951; i < year.length; i++){
            year[i] += year[i - 1];  // Generating Prefix Sum
            
            if(year[i] > maxNum){
                maxNum = year[i];
                maxYear = i;
            }
        }
        
        return maxYear;
    }
}


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