class Solution {

    int rows, cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacific =
                new boolean[rows][cols];

        boolean[][] atlantic =
                new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            dfs(heights, pacific, r, 0,
                    heights[r][0]);
            dfs(heights, atlantic, r,
                    cols - 1,
                    heights[r][cols - 1]);
        }

        for (int c = 0; c < cols; c++) {
            dfs(heights, pacific, 0, c,
                    heights[0][c]);
            dfs(heights, atlantic,
                    rows - 1, c,
                    heights[rows - 1][c]);
        }

        List<List<Integer>> result =
                new ArrayList<>();

        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                if (pacific[r][c] &&
                    atlantic[r][c]) {

                    result.add(
                        Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights,
                     boolean[][] ocean,
                     int r,
                     int c,
                     int prevHeight) {

        if (r < 0 || c < 0 ||
            r >= rows || c >= cols ||
            ocean[r][c] ||
            heights[r][c] < prevHeight)
            return;

        ocean[r][c] = true;

        dfs(heights, ocean,
            r + 1, c,
            heights[r][c]);

        dfs(heights, ocean,
            r - 1, c,
            heights[r][c]);

        dfs(heights, ocean,
            r, c + 1,
            heights[r][c]);

        dfs(heights, ocean,
            r, c - 1,
            heights[r][c]);
    }
}