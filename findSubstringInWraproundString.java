/*
Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".

Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s. In particular, your input is the string p and you need to output the number of different non-empty substrings of p in the string s.

Note: p consists of only lowercase English letters and the size of p might be over 10000.

Example 1:
Input: "a"
Output: 1

Explanation: Only the substring "a" of string "a" is in the string s.
Example 2:
Input: "cac"
Output: 2
Explanation: There are two substrings "a", "c" of string "cac" in the string s.
Example 3:
Input: "zab"
Output: 6
Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.

*/

public class Solution {
    public int findSubstringInWraproundString(String p) {
        // The max number of unique substrings ending with a letter
        // is the length of the max continuous substring ending with that letter
        // Ex: given "abcd", the max # of unique substrings ending with 'd' is 4

        // If there are portions of overlapping strings, we just need to consider the longest one

        // Total number of unique substrings would be to sum up
        // all the unique substrings ending with a particular letter

        int[] count = new int[26];  // to store # of unique substrings ending with a particular letter
        int continuousLength = 0;

        for (int i = 0; i < p.length(); i++) {
            // p.charAt(i) - p.charAt(i - 1) == 1 checks if this letter is alphabetically after the prev one
            // p.charAt(i - 1) - p.charAt(i) == 25 covers the case of 'za'
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)) {
                continuousLength++;
            } else {
                // when i == 0 or when this letter is independent / not alphabetically after the prev letter
                continuousLength = 1;
            }

            // find the correct index
            int index = p.charAt(i) - 'a';
            // Takes care of overlapping substrings
            count[index] = Math.max(count[index], continuousLength);
        }

        int result = 0;

        for (int n: count) {
            result += n;
        }

        return result;
    }
}
