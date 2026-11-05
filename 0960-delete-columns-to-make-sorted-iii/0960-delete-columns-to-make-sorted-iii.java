class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                if (isValid(strs, j, i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        return m - maxLen;
    }
    
    private boolean isValid(String[] strs, int col1, int col2) {
        for (String s : strs) {
            if (s.charAt(col1) > s.charAt(col2)) {
                return false;
            }
        }
        return true;
    }
}