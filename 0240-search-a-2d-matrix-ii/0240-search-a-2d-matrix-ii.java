class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int ele[] : matrix) {
            for (int e : ele) {
                if (e == target) {
                    return true;
                }
            }
        }
        return false;
    }
}