class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean found = false;
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    found = true;
                }
            }
        }
        
        int steps = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        if (grid[nr][nc] == 1) {
                            return steps;
                        }
                        if (grid[nr][nc] == 0) {
                            grid[nr][nc] = 2;
                            queue.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
    
    private void dfs(int[][] grid, int r, int c, Queue<int[]> queue) {
        int n = grid.length;
        if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != 1) {
            return;
        }
        grid[r][c] = 2;
        queue.offer(new int[]{r, c});
        dfs(grid, r - 1, c, queue);
        dfs(grid, r + 1, c, queue);
        dfs(grid, r, c - 1, queue);
        dfs(grid, r, c + 1, queue);
    }
}