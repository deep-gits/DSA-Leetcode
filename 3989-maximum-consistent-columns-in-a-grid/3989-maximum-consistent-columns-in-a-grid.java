class Solution {
    public int maxConsistentColumns(int[][] grid, int limit) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] cols = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cols[j][i] = grid[i][j];
            }
        }
        
        int[] dp = new int[n];
        int maxCols = 0;
        
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            int[] colI = cols[i];
            
            for (int j = 0; j < i; j++) {
                boolean valid = true;
                int[] colJ = cols[j];
                
                for (int r = 0; r < m; r++) {
                    if (Math.abs(colI[r] - colJ[r]) > limit) {
                        valid = false;
                        break;
                    }
                }
                
                if (valid) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            
            if (dp[i] > maxCols) {
                maxCols = dp[i];
            }
        }
        
        return maxCols;
    }
}