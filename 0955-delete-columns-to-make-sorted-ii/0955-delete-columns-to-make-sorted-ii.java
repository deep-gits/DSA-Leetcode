class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int ans = 0;
        boolean[] sorted = new boolean[n - 1];
        
        for (int j = 0; j < strs[0].length(); j++) {
            int i;
            for (i = 0; i + 1 < n; i++) {
                if (!sorted[i] && strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    ans++;
                    break;
                }
            }
            
            if (i + 1 == n) {
                for (i = 0; i + 1 < n; i++) {
                    sorted[i] = sorted[i] || strs[i].charAt(j) < strs[i + 1].charAt(j);
                }
            }
        }
        
        return ans;
    }
}