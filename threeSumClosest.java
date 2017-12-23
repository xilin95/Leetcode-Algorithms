/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = nums[0] + nums[1] + nums[2];
        int length = nums.length;

        // enables adjusting j and k based on if sum is larger or smaller than target
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == target) {
                    return sum;
                }

                // found a new sum that is closer to target
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }

                // if sum > target, try to reduce it by getting a smaller number and moving k to the left
                if (sum > target) {
                    k--;
                } else {
                // if sum < target, try to increase it by getting a larger number and moving j to the right
                    j++;
                }
            }
        }

        return closestSum;
    }
}
