class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        boolean[] isTravel = new boolean[lastDay + 1];
        for (int day : days) {
            isTravel[day] = true;
        }
        
        int[] dp = new int[lastDay + 1];
        for (int i = 1; i <= lastDay; i++) {
            if (!isTravel[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            
            int cost1 = dp[i - 1] + costs[0];
            int cost7 = dp[Math.max(0, i - 7)] + costs[1];
            int cost30 = dp[Math.max(0, i - 30)] + costs[2];
            
            dp[i] = Math.min(cost1, Math.min(cost7, cost30));
        }
        
        return dp[lastDay];
    }
}