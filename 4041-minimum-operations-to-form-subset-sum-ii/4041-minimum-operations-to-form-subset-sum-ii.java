class Solution {
    public int minOperations(int[] nums, int sum) {
        int inf = 1_000_000_000;
        int[] dp = new int[sum + 1];
        java.util.Arrays.fill(dp, inf);
        dp[0] = 0;
        
        for (int x : nums) {
            for (int w = sum; w >= 0; w--) {
                for (int i = 0, y = x; y <= w; i++, y *= 2) {
                    dp[w] = Math.min(dp[w], dp[w - y] + i);
                }
                for (int i = 1, y = x / 2; y > 0; i++, y /= 2) {
                    for (int j = 0, z = y; z <= w; j++, z *= 2) {
                        dp[w] = Math.min(dp[w], dp[w - z] + i + j);
                    }
                }
            }
        }
        
        return dp[sum] == inf ? -1 : dp[sum];
    }
}