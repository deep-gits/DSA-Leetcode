import java.util.*;

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int[] ans = new int[q];
        
        for (int i = 0; i < q; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];
            
            Pair[] trimmed = new Pair[n];
            for (int j = 0; j < n; j++) {
                String s = nums[j];
                String sub = s.substring(s.length() - trim);
                trimmed[j] = new Pair(sub, j);
            }
            
            Arrays.sort(trimmed, (a, b) -> {
                int cmp = a.val.compareTo(b.val);
                if (cmp != 0) return cmp;
                return Integer.compare(a.index, b.index);
            });
            
            ans[i] = trimmed[k - 1].index;
        }
        
        return ans;
    }
    
    private static class Pair {
        String val;
        int index;
        
        Pair(String val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}