class Solution {
    private static class Cell implements Comparable<Cell> {
        int row;
        int col;
        int height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

        @Override
        public int compareTo(Cell other) {
            return Integer.compare(this.height, other.height);
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int rows = heightMap.length;
        int cols = heightMap[0].length;
        boolean[][] visited = new boolean[rows][cols];
        PriorityQueue<Cell> minHeap = new PriorityQueue<>();

        // Add boundary cells to the min-heap
        for (int i = 0; i < rows; i++) {
            minHeap.offer(new Cell(i, 0, heightMap[i][0]));
            minHeap.offer(new Cell(i, cols - 1, heightMap[i][cols - 1]));
            visited[i][0] = true;
            visited[i][cols - 1] = true;
        }

        for (int j = 0; j < cols; j++) {
            minHeap.offer(new Cell(0, j, heightMap[0][j]));
            minHeap.offer(new Cell(rows - 1, j, heightMap[rows - 1][j]));
            visited[0][j] = true;
            visited[rows - 1][j] = true;
        }

        int waterTrapped = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!minHeap.isEmpty()) {
            Cell curr = minHeap.poll();

            for (int[] dir : directions) {
                int nextRow = curr.row + dir[0];
                int nextCol = curr.col + dir[1];

                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && !visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    // If neighbor is lower than current boundary, water can be trapped
                    if (heightMap[nextRow][nextCol] < curr.height) {
                        waterTrapped += curr.height - heightMap[nextRow][nextCol];
                        minHeap.offer(new Cell(nextRow, nextCol, curr.height));
                    } else {
                        minHeap.offer(new Cell(nextRow, nextCol, heightMap[nextRow][nextCol]));
                    }
                }
            }
        }

        return waterTrapped;
    }
}