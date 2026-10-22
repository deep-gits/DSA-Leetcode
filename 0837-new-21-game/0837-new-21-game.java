class Solution {
    public double new21Game(int n, int k, int w) {
        if (k == 0 || n >= k + w) {
            return 1.0;
        }
        
        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        double windowSum = 1.0; // Sum of dp[j] for max(0, i - w) <= j <= i - 1 and j < k
        double ans = 0.0;
        
        for (int i = 1; i <= n; i++) {
            dp[i] = windowSum / w;
            
            if (i < k) {
                windowSum += dp[i];
            } else {
                ans += dp[i];
            }
            
            if (i - w >= 0) {
                if (i - w < k) {
                    windowSum -= dp[i - w];
                }
            }
        }
        
        return ans;
    }
}