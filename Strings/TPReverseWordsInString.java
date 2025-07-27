//using a while loop makes everything simple. loop from end , find a word using two pointers, append, and add space.

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            // Skip trailing spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i < 0)
                break;

            int j = i;
            // Move j to the start of the word
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }

            // Append the word
            sb.append(s.substring(j + 1, i + 1));
            sb.append(' '); // Add space between words

            i = j - 1; // Move to next word
        }

        return sb.toString().trim();
    }
}

// brute force: using stiring methods
/* 
public String reverseWords(String s) {
        int first =0;
        StringBuilder sb = new StringBuilder();
        String trim = s.trim();
        String words[] = trim.split(" ");
        
        for(int i = words.length -1;i>=0;i--){
            System.out.println('.' + words[i].trim() + '.');  
            if (words[i].trim().isEmpty()){
                continue;
            }
            sb.append(words[i].trim());
            if(i==0){
                continue;
            }
            sb.append(' ');
        }
        return sb.toString();
    }
 */

/*
 * 51. Reverse Words in a String
 * Solved
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Given an input string s, reverse the order of the words.
 * 
 * A word is defined as a sequence of non-space characters. The words in s will
 * be separated by at least one space.
 * 
 * Return a string of the words in reverse order concatenated by a single space.
 * 
 * Note that s may contain leading or trailing spaces or multiple spaces between
 * two words. The returned string should only have a single space separating the
 * words. Do not include any extra spaces.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 * 
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing
 * spaces.
 * Example 3:
 * 
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single
 * space in the reversed string.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104
 * s contains English letters (upper-case and lower-case), digits, and spaces '
 * '.
 * There is at least one word in s.
 * 
 * 
 * Follow-up: If the string data type is mutable in your language, can you solve
 * it in-place with O(1) extra space?
 */