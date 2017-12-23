/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int max_so_far = nums[0];
        int curr_max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // if curr_max + nums[i] > curr_max, then update curr_max
            // else, set curr_max to the current number
            curr_max = Math.max(nums[i], curr_max + nums[i]);
            // update max_so_far if it is smaller than curr_max
            max_so_far = Math.max(max_so_far, curr_max);
        }

        return max_so_far;
    }
}
