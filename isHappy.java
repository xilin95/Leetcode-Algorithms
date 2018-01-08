/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/

class Solution {
    public boolean isHappy(int n) {
        int oldNum = n;
        HashSet<Integer> seen = new HashSet<Integer>();

        while (oldNum > 0) {
            int newNum = 0;
            while (oldNum > 0) {
                newNum += Math.pow(oldNum % 10, 2);
                oldNum /= 10;
            }

            // loop
            if (!seen.add(newNum)) {
                return false;
            }

            if (newNum == 1) {
                return true;
            }

            oldNum = newNum;
        }

        return false;
    }
}
