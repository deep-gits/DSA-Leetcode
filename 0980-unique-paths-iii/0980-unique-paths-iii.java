class Solution {
    private int res = 0;
    private int empty = 0;
    
    public int uniquePathsIII(int[][] grid) {
        int startX = 0, startY = 0;
        int rows = grid.length, cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                    empty++;
                } else if (grid[i][j] == 0) {
                    empty++;
                }
            }
        }
        
        dfs(grid, startX, startY, 0);
        return res;
    }
    
    private void dfs(int[][] grid, int r, int c, int count) {
        int rows = grid.length, cols = grid[0].length;
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == -1) {
            return;
        }
        
        if (grid[r][c] == 2) {
            if (count == empty) {
                res++;
            }
            return;
        }
        
        int temp = grid[r][c];
        grid[r][c] = -1;
        count++;
        
        dfs(grid, r + 1, c, count);
        dfs(grid, r - 1, c, count);
        dfs(grid, r, c + 1, count);
        dfs(grid, r, c - 1, count);
        
        grid[r][c] = temp;
    }
}