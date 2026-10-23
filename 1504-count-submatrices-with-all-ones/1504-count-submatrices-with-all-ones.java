class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] height = new int[n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    height[j] = 0;
                } else {
                    height[j] += 1;
                }
            }
            count += countRow(height);
        }
        return count;
    }

    private int countRow(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int total = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                int prevIndex = stack.peek();
                dp[i] = dp[prevIndex] + height[i] * (i - prevIndex);
            } else {
                dp[i] = height[i] * (i + 1);
            }
            stack.push(i);
            total += dp[i];
        }
        return total;
    }
}