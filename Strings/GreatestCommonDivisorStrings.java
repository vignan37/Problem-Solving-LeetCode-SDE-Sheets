//1. Interesting condition to check if they are divisible or not, str1+str2 ==str2+str1
// 2. use gcd to get the substring length

//GCD approach

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        int l1= str1.length();
        int l2= str2.length();
        return str1.substring(0,gcd(l1,l2));
    }
    private int gcd(int num1, int num2){
        if(num2==0){
            return num1;
        }
        return gcd(num2,num1%num2);
    }
}

//Other approach
//remove the smaller prefix from larger one, until both are equal.

// https://leetcode.com/problems/greatest-common-divisor-of-strings
/* 
1071. Greatest Common Divisor of Strings
Solved

For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

 

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
 

Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of English uppercase letters.
*/