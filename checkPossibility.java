/*
Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

Example 1:
Input: [4,2,3]
Output: True
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:
Input: [4,2,1]
Output: False
Explanation: You can't get a non-decreasing array by modify at most one element.
Note: The n belongs to [1, 10,000].


*/

class Solution {
    public boolean checkPossibility(int[] nums) {
        int change = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i - 1] > nums[i]) {
                change++;
                // It is preferable to change the number at previous index
                // b/c it reduces the risk of error later on
                // (So if we are at index 1, if index 0's num is greater than index 1's,
                // change index 0's num to that of index 1's)
                // Have to also make sure that number at 2 indexes before is smaller than the current number
                // Ex: [4,2,3] should change 4 to 2
                // Ex: [1,6,5,7] should change 6 to 5
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                  // Ex: [5,6,2,3]; should change 2 to 6, instead of changing 6 to 2
                    nums[i] = nums[i - 1];
                }
            }

            if (change > 1) {
                return false;
            }

        }

        return true;
    }
}
