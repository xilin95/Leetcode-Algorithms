/*
Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.

Example 1:
Input: "sea", "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Note:
The length of given words won't exceed 500.
Characters in given words can only be lower-case letters.
*/


// Method 1: memoization
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];

        return word1.length() + word2.length() - 2 * lcs(memo, word1.length() - 1, word2.length() - 1, word1, word2);
    }

    // returns longest common string of the two words
    private int lcs(int[][] memo, int i, int j, String word1, String word2) {
        // if current characters of word1 and word2 are the same,
        // memo[i][j] = memo[i - 1][j - 1] + 1;
        // else, memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]) to get the lcs thus far;

        // base case
        if (i < 0 || j < 0) {
            return 0;
        }

        if (memo[i][j] > 0) {
            return memo[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = lcs(memo, i - 1, j - 1, word1, word2) + 1;
        } else {
            memo[i][j] = Math.max(lcs(memo, i - 1, j, word1, word2), lcs(memo, i, j - 1, word1, word2));
        }

        return memo[i][j];
    }
}

// Method 2: Dynamic Programming
class Solution {
    public int minDistance(String word1, String word2) {
        // dynamic programming
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0) {
                    continue;
                }

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }
}
