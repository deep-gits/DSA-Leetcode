class Solution {
    public int minDays(int n) {
        int[] dp = new int[n + 1];
        dp[0] = -1;
        
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE / 2;
            for (int j = 1; ; j++) {
                int score = j * (j + 1) / 2;
                if (score > i) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - score] + j + 1);
            }
        }
        
        return dp[n];
    }
}