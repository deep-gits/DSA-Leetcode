import java.util.List;

class Solution {
    public int minCost(String source, String target, List<List<String>> rules, int[] costs) {
        int n = source.length();
        int m = rules.size();
        
        long[] ruleCosts = new long[m];
        char[][] patterns = new char[m][];
        char[][] replacements = new char[m][];
        int[] ruleLens = new int[m];
        
        for (int i = 0; i < m; i++) {
            patterns[i] = rules.get(i).get(0).toCharArray();
            replacements[i] = rules.get(i).get(1).toCharArray();
            ruleLens[i] = patterns[i].length;
            
            ruleCosts[i] = costs[i];
            for (char c : patterns[i]) {
                if (c == '*') {
                    ruleCosts[i]++;
                }
            }
        }
        
        char[] sChars = source.toCharArray();
        char[] tChars = target.toCharArray();
        
        long INF = Long.MAX_VALUE / 2;
        long[] dp = new long[n + 1];
        java.util.Arrays.fill(dp, INF);
        dp[n] = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            if (sChars[i] == tChars[i]) {
                dp[i] = dp[i + 1];
            }
            
            for (int k = 0; k < m; k++) {
                int L = ruleLens[k];
                if (i + L <= n) {
                    boolean match = true;
                    char[] p = patterns[k];
                    char[] r = replacements[k];
                    
                    for (int j = 0; j < L; j++) {
                        if (r[j] != tChars[i + j]) {
                            match = false;
                            break;
                        }
                        char pChar = p[j];
                        if (pChar != '*' && pChar != sChars[i + j]) {
                            match = false;
                            break;
                        }
                    }
                    
                    if (match) {
                        long cost = ruleCosts[k] + dp[i + L];
                        if (cost < dp[i]) {
                            dp[i] = cost;
                        }
                    }
                }
            }
        }
        
        return dp[0] >= INF ? -1 : (int) dp[0];
    }
}