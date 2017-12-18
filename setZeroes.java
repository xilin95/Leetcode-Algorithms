// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColumnZero = false;
        // first round: mark which column and row should become 0s
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // if a number is 0, mark the first number in its column and row to 0
                // distinguish between marker and original 0s in the first row and first column
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if (i == 0) {
                        firstRowZero = true;
                    }

                    if (j == 0) {
                        firstColumnZero = true;
                    }
                }
            }
        }

        // second round: change the rows and columns to 0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                // set a number to 0 if it is in a row or column that is supposed to be 0
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowZero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColumnZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
