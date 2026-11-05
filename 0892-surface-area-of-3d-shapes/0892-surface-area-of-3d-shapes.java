class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = grid[i][j];
                if (v > 0) {
                    ans += v * 4 + 2;
                    if (i > 0) {
                        ans -= Math.min(v, grid[i - 1][j]) * 2;
                    }
                    if (j > 0) {
                        ans -= Math.min(v, grid[i][j - 1]) * 2;
                    }
                }
            }
        }
        return ans;
    }
}