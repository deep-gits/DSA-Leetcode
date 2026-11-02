import java.util.Arrays;

class Solution {
    int[][][] memo;
    int n;
    int[][] grid;

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.memo = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -999999);
            }
        }
        int ans = dp(0, 0, 0);
        return Math.max(0, ans);
    }

    private int dp(int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2;
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return -999999;
        }
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }
        if (memo[r1][c1][r2] != -999999) {
            return memo[r1][c1][r2];
        }
        int cherries = 0;
        if (r1 == r2 && c1 == c2) {
            cherries += grid[r1][c1];
        } else {
            cherries += grid[r1][c1] + grid[r2][c2];
        }
        int next = Math.max(Math.max(dp(r1 + 1, c1, r2 + 1), dp(r1 + 1, c1, r2)),
                            Math.max(dp(r1, c1 + 1, r2 + 1), dp(r1, c1 + 1, r2)));
        cherries += next;
        return memo[r1][c1][r2] = cherries;
    }
}