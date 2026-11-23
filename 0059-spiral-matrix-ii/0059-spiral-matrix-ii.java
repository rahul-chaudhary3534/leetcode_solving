
class Solution {
    public int[][] generateMatrix(int n) {

        int[][] ans = new int[n][n];

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int num = 1;

        while (top <= bottom && left <= right) {

            // 1. Left to Right
            for (int i = left; i <= right; i++) {
                ans[top][i] = num++;
            }
            top++;

            // 2. Top to Bottom
            for (int i = top; i <= bottom; i++) {
                ans[i][right] = num++;
            }
            right--;

            // 3. Right to Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans[bottom][i] = num++;
                }
                bottom--;
            }

            // 4. Bottom to Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans[i][left] = num++;
                }
                left++;
            }
        }

        return ans;
    }
}
