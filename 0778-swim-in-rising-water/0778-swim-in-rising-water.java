class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        
        // Min-heap storing {elevation, row, col}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[] { grid[0][0], 0, 0 });
        visited[0][0] = true;
        
        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int elevation = curr[0];
            int r = curr[1];
            int c = curr[2];
            
            // If we reach the bottom-right corner, return the max elevation encountered
            if (r == n - 1 && c == n - 1) {
                return elevation;
            }
            
            for (int[] dir : directions) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];
                
                if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && !visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    // The time required to reach the neighbor is the maximum of current elevation and neighbor's elevation
                    int nextElevation = Math.max(elevation, grid[nextR][nextC]);
                    minHeap.offer(new int[] { nextElevation, nextR, nextC });
                }
            }
        }
        
        return -1;
    }
}