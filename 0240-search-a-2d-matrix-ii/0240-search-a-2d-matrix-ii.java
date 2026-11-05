class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length-1;
        int r = 0;
        int c = n;
        while(r<m && c>=0){
            if(matrix[r][c]==target){
                return true;
            }
            else if(matrix[r][c]>target){
                c--;
            }
            else if(matrix[r][c]<target){
                r++;
            }
        }
        return false;

        
    }
}