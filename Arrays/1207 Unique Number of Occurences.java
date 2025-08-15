//just loops : Sort, check freq, Sort freq array and check duplicate freq.
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        int[] v = new int[arr.length];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            int cnt = 1;

            // Count occurrences of the current element
            while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
                cnt++;
                i++;
            }
            v[idx++] = cnt;
        }
        Arrays.sort(v);
        for (int i = 1; i < v.length; i++) {
            if (v[i] == v[i - 1]) {
                return false;
            }
        }
        return true;
    }
}

// Using map and then set to check for duplicates
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> hm = new HashMap<>();
        for(int val : arr){
            if(hm.containsKey(val)){
                hm.put(val,(hm.get(val)+1));
            }
            else{
                hm.put(val,1);
            }
        }
        Set<Integer> s = new HashSet<>(hm.values());
        if(hm.size()!= s.size()){
            return false;
        }
        else return true;

    }
}

/* 
[**1207. Unique Number of Occurrences**](https://leetcode.com/problems/unique-number-of-occurrences/)

Given an array of integers `arr`, return `true` *if the number of occurrences of each value in the array is **unique** or* `false` *otherwise*.

**Example 1:**

```
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
```

**Example 2:**

```
Input: arr = [1,2]
Output: false

```

**Example 3:**

```
Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true

```

**Constraints:**

- `1 <= arr.length <= 1000`
- `1000 <= arr[i] <= 1000`
*/