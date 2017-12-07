/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
*/

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        int longestLen = 1;
        String longestStr = s.substring(0,1);

        for(int i = 0; i < s.length(); i++) {
            int len = 1;
            int left = i - 1;
            int right = i + 1;

            while (right < s.length() && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                len+=2;
            }

            if(len > longestLen) {
                longestLen = len;
                longestStr = s.substring(right - longestLen, right);
            }
        }

        return longestStr;
    }
}
