class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int nj = (j - rowShift[i] + n) % n;
                temp[i][nj] = grid[i][j];
            }
        }
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int ni = (i - colShift[j] + n) % n;
                ans[ni][j] = temp[i][j];
            }
        }
        return ans;
    }
}