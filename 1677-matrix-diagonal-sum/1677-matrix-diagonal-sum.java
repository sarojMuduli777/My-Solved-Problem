class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;

        if (n == 1) {
            return mat[0][0];
        }

        int sum = 0;

        for (int i = 0, j = n-1; i < n; i++, j--) {
            sum += mat[i][i];
            sum += mat[i][j];
        }

        if (n % 2 != 0) {
            sum -= mat[n/2][n/2];
        }

        return sum;
    }
}