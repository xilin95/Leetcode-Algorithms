/*
Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

Example 1:
Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are:
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
Note:
The length of the given array won't exceed 1000.
The integers in the given array are in the range of [0, 1000].
*/

class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        // Useful for deciding nums3: any c that is after index of num2 and < nums[i] + nums[j] would qualify
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                // Recognize that for a set with the same nums[i],
                // choosing a bigger j can have the search for k start at where it last left off
                // because for any k < k(i,j) would satisfy the requirement that nums[i] + nums[j] > nums[k]
                k = findRightBound(nums, k, nums.length - 1, nums[i] + nums[j]);
                // number of k's between j and the right bound
                count += (k - j - 1);
            }
        }

        return count;
    }

    private int findRightBound(int[] nums, int left, int right, int max) {
        while (right >= left && right < nums.length && left < nums.length && left >= 0) {
            int mid = (left + right) / 2;

            if (nums[mid] >= max) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return left;
    }
}
