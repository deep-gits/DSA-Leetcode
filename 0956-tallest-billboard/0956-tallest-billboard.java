class Solution {
    public int tallestBillboard(int[] rods) {
        int sum = 0;
        for (int r : rods) sum += r;
        
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for (int r : rods) {
            int[] nextDp = dp.clone();
            for (int diff = 0; diff <= sum - r; diff++) {
                if (dp[diff] < 0) continue;
                
                nextDp[diff + r] = Math.max(nextDp[diff + r], dp[diff]);
                
                int diff2 = Math.abs(diff - r);
                int add2 = Math.min(diff, r);
                nextDp[diff2] = Math.max(nextDp[diff2], dp[diff] + add2);
            }
            dp = nextDp;
        }
        
        return dp[0];
    }
}