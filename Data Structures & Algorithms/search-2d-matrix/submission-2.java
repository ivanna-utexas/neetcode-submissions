class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //each row is in increasing order
        //search which row it could be in by seeing am i between 0 - matrix[length]
        for(int row = 0; row < matrix.length; row++) {
            int first = matrix[row][0];
            int last = matrix[row][matrix[row].length - 1];
            if(target >= first && target <= last) {
                int l = 0, r = matrix[row].length - 1;
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if (matrix[row][m] == target) return true;
                    else if (matrix[row][m] < target) l = m + 1;
                    else r = m - 1;
                }
                return false;
            }
        }
        
        return false;
    }
}
