class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int n = s.length();
        int[][] next = new int[n + 1][26];
        
        for (int j = 0; j < 26; j++) {
            next[n][j] = -1;
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                next[i][j] = next[i + 1][j];
            }
            next[i][s.charAt(i) - 'a'] = i;
        }
        
        int ans = 0;
        for (String word : words) {
            int curr = 0;
            boolean match = true;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (curr >= n || next[curr][c] == -1) {
                    match = false;
                    break;
                }
                curr = next[curr][c] + 1;
            }
            if (match) {
                ans++;
            }
        }
        
        return ans;
    }
}