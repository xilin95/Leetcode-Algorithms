/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.


*/
class Solution {
    public int numSquares(int n) {
        // DP
        int[] count = new int[n + 1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[0] = 0;

        // Time: O(n^2)
        // Space: O(n)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                // logic: all numbers is composed of (j * j + remainder)
                // testing j * j until it is <= given n
                // +1 accounts for the perfect square number/ j * j
                // and count[i - j * j] is count of perfect square nums making up the remainder
                count[i] = Math.min(count[i], count[i - j * j] + 1);
            }
        }

        return count[n];
    }

}
