class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.isEmpty() || forest.get(0).isEmpty()) {
            return -1;
        }

        int rows = forest.size();
        int cols = forest.get(0).size();

        // Collect all trees with their heights and coordinates: {height, r, c}
        List<int[]> trees = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int height = forest.get(r).get(c);
                if (height > 1) {
                    trees.add(new int[] { height, r, c });
                }
            }
        }

        // Sort trees by height in ascending order
        trees.sort((a, b) -> Integer.compare(a[0], b[0]));

        int totalSteps = 0;
        int startR = 0;
        int startC = 0;

        for (int[] tree : trees) {
            int targetR = tree[1];
            int targetC = tree[2];

            int steps = bfs(forest, startR, startC, targetR, targetC, rows, cols);
            if (steps == -1) {
                return -1;
            }

            totalSteps += steps;
            startR = targetR;
            startC = targetC;
        }

        return totalSteps;
    }

    private int bfs(List<List<Integer>> forest, int startR, int startC, int targetR, int targetC, int rows, int cols) {
        if (startR == targetR && startC == targetC) {
            return 0;
        }

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] { startR, startC });
        visited[startR][startC] = true;

        int steps = 0;
        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for (int[] dir : directions) {
                    int nextR = curr[0] + dir[0];
                    int nextC = curr[1] + dir[1];

                    if (nextR == targetR && nextC == targetC) {
                        return steps;
                    }

                    if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols && !visited[nextR][nextC]) {
                        if (forest.get(nextR).get(nextC) > 0) {
                            visited[nextR][nextC] = true;
                            queue.offer(new int[] { nextR, nextC });
                        }
                    }
                }
            }
        }

        return -1;
    }
}