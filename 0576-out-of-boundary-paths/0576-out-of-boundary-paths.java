class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove <= 0) {
            return 0;
        }
        
        int MOD = 1_000_000_007;
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        int ans = 0;
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int step = 0; step < maxMove; step++) {
            int[][] temp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][j] > 0) {
                        for (int[] d : directions) {
                            int ni = i + d[0];
                            int nj = j + d[1];
                            if (ni < 0 || ni >= m || nj < 0 || nj >= n) {
                                ans = (ans + dp[i][j]) % MOD;
                            } else {
                                temp[ni][nj] = (temp[ni][nj] + dp[i][j]) % MOD;
                            }
                        }
                    }
                }
            }
            dp = temp;
        }
        
        return ans;
    }
}