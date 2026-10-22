import java.util.HashSet;

class Solution {
    private static final long MOD1 = 1000000007L;
    private static final long MOD2 = 1000000009L;
    private static final long BASE = 31;

    public String longestDupSubstring(String s) {
        int n = s.length();
        
        // Precompute powers of BASE for both moduli
        long[] pow1 = new long[n];
        long[] pow2 = new long[n];
        pow1[0] = 1;
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow1[i] = (pow1[i - 1] * BASE) % MOD1;
            pow2[i] = (pow2[i - 1] * BASE) % MOD2;
        }
        
        int left = 1;
        int right = n - 1;
        int maxLength = 0;
        int startIdx = -1;
        
        // Binary search on the length of the substring
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int idx = findDuplicate(s, mid, pow1, pow2);
            
            if (idx != -1) {
                maxLength = mid;
                startIdx = idx;
                left = mid + 1; // Try to find a longer duplicate
            } else {
                right = mid - 1; // Try shorter length
            }
        }
        
        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + maxLength);
    }
    
    private int findDuplicate(String s, int len, long[] pow1, long[] pow2) {
        int n = s.length();
        long hash1 = 0;
        long hash2 = 0;
        
        // Compute hash for the first window of size `len`
        for (int i = 0; i < len; i++) {
            long val = s.charAt(i) - 'a' + 1;
            hash1 = (hash1 * BASE + val) % MOD1;
            hash2 = (hash2 * BASE + val) % MOD2;
        }
        
        HashSet<Long> seen = new HashSet<>();
        seen.add((hash1 << 32) | (hash2 & 0xFFFFFFFFL));
        
        // Slide the window across the string
        for (int i = 1; i <= n - len; i++) {
            long prev = s.charAt(i - 1) - 'a' + 1;
            long next = s.charAt(i + len - 1) - 'a' + 1;
            
            hash1 = (hash1 - prev * pow1[len - 1] % MOD1 + MOD1) % MOD1;
            hash1 = (hash1 * BASE + next) % MOD1;
            
            hash2 = (hash2 - prev * pow2[len - 1] % MOD2 + MOD2) % MOD2;
            hash2 = (hash2 * BASE + next) % MOD2;
            
            long combinedHash = (hash1 << 32) | (hash2 & 0xFFFFFFFFL);
            if (!seen.add(combinedHash)) {
                return i; // Duplicate found, return start index
            }
        }
        
        return -1;
    }
}