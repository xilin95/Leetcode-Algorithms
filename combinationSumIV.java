/*
Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
*/

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        // -1 indicates that there is no result stored for that target yet
        Arrays.fill(dp, -1);
        // the only way to meet target of 0 is to have nothing since all nums are positive
        dp[0] = 1;
        return helper(nums, dp, target);
    }

    private int helper(int[] nums, int[] dp, int remaining) {
        // if ways to get a number has already been calcualted before
        // don't repeat the process
        if (dp[remaining] != -1) {
            return dp[remaining];
        }

        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= remaining) {
                total += helper(nums, dp, remaining - nums[i]);
            }
        }

        dp[remaining] = total;

        return dp[remaining];
    }
}
