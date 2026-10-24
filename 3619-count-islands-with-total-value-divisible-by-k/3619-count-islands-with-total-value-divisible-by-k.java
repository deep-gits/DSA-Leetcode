class Solution {
    private int[][] grid;
    private int m, n;
    private int k;

    public int countIslands(int[][] grid, int k) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.k = k;
        
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    long islandSum = dfs(i, j);
                    if (islandSum % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private long dfs(int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] <= 0) {
            return 0;
        }
        
        long val = grid[r][c];
        grid[r][c] = 0; // Mark as visited
        
        val += dfs(r + 1, c);
        val += dfs(r - 1, c);
        val += dfs(r, c + 1);
        val += dfs(r, c - 1);
        
        return val;
    }
}