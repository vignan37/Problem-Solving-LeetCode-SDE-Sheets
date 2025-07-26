
//Using two pointers TP at both ends and checking if left vovel and right end vovel if both then swap
// Use String builder as string is immutable.
// to convert character to lowercase use Character.toLowerCase('A');

class Solution {
    public String reverseVowels(String s) {
        int i=0;
        int j = s.length()-1;
        StringBuilder sb = new StringBuilder(s);
        while(i<j){
            char iValue = Character.toLowerCase(s.charAt(i));
            char jValue = Character.toLowerCase(s.charAt(j));
            boolean isLeftVovel = (iValue == 'a' || iValue == 'e' || iValue == 'i' 
            || iValue == 'o' || iValue == 'u');
            boolean isRightVovel = (jValue == 'a' || jValue == 'e' || jValue == 'i' 
            || jValue == 'o' || jValue == 'u');
            
            if(!isLeftVovel){
                i++;
            }
            if(!isRightVovel){
                j--;
            }
            if(isLeftVovel && isRightVovel){
                sb.setCharAt(i,s.charAt(j));
                sb.setCharAt(j,s.charAt(i));
                i++;
                j--;
            }

        }
        return sb.toString();
    }
}
/*
 
This is a part of LC Blind 75

https://leetcode.com/problems/reverse-vowels-of-a-string/
345. Reverse Vowels of a String
Solved
Easy
Topics
premium lock icon
Companies
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"

 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
 */