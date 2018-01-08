/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        // Use a hash map to store all previously calcualted sum
        // logic: if currentSum - target = prevSum
        // then that means there exists a continous subarray equaling target
        HashMap<Integer, Integer> sums = new HashMap<Integer, Integer>();
        //
        sums.put(0, 1);

        int currentSum = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (sums.containsKey(currentSum - k)) {
                result += sums.get(currentSum - k);
            }

            sums.put(currentSum, sums.getOrDefault(currentSum, 0) + 1);
        }

        return result;
    }

}
