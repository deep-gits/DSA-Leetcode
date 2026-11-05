class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] g = new int[n * 3][n * 3];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                int r = i * 3, col = j * 3;
                if (c == '/') {
                    g[r][col + 2] = 1;
                    g[r + 1][col + 1] = 1;
                    g[r + 2][col] = 1;
                } else if (c == '\\') {
                    g[r][col] = 1;
                    g[r + 1][col + 1] = 1;
                    g[r + 2][col + 2] = 1;
                }
            }
        }
        
        int regions = 0;
        for (int i = 0; i < n * 3; i++) {
            for (int j = 0; j < n * 3; j++) {
                if (g[i][j] == 0) {
                    dfs(g, i, j);
                    regions++;
                }
            }
        }
        
        return regions;
    }
    
    private void dfs(int[][] g, int r, int c) {
        if (r < 0 || c < 0 || r >= g.length || c >= g[0].length || g[r][c] != 0) {
            return;
        }
        g[r][c] = 1;
        dfs(g, r + 1, c);
        dfs(g, r - 1, c);
        dfs(g, r, c + 1);
        dfs(g, r, c - 1);
    }
}