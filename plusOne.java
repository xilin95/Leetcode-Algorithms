/*
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
*/

class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        boolean done = false;

        while (!done) {
            // for cases like [9]
            if (index < 0) {
                int[] temp = new int[digits.length + 1];
                for (int i = temp.length - 1; i > 0; i--) {
                  temp[i] = digits[i - 1];
                }

                temp[0] = 1;
                digits = temp;
                done = true;
            } else {
                if (digits[index] + 1 < 10) {
                    digits[index] = digits[index] + 1;
                    done = true;
                } else if (digits[index] + 1 == 10) {
                    digits[index] = 0;
                    index--;
                }
            }


        }

        return digits;
    }
}
