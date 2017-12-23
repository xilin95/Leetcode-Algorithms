/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

class Solution {
    public int rob(int[] nums) {
        // O(n) time complexity, O(1) space
        // two variables to keep track of the current max of either robbing the current house or not robbing the current house
        int rob = 0;
        int notRob = 0;

        for(int i = 0; i < nums.length; i++) {
            // currMoney = money from not robbing prev. house + money of this house
            int currMoney = notRob + nums[i];
            // notRob is the maximum of robbing previous house vs not robbing previous house
            notRob = Math.max(rob, notRob);
            // rob is the maximum between robbing this house vs not robbing this house
            rob = Math.max(currMoney, notRob);
        }

        return Math.max(rob, notRob);
    }
}
