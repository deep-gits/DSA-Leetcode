import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxRepOpt1(String text) {
        int[] count = new int[26];
        int n = text.length();
        for (int i = 0; i < n; i++) {
            count[text.charAt(i) - 'a']++;
        }
        
        // Group identical consecutive characters into runs
        List<int[]> runs = new ArrayList<>();
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && text.charAt(j) == text.charAt(i)) {
                j++;
            }
            runs.add(new int[] { text.charAt(i) - 'a', j - i });
            i = j;
        }
        
        int maxLen = 0;
        
        // Case 1: Extend a single run by 1 if there is another character of the same type outside
        for (int[] run : runs) {
            int c = run[0];
            int len = run[1];
            maxLen = Math.max(maxLen, Math.min(len + 1, count[c]));
        }
        
        // Case 2: Merge two runs of the same character separated by a single different character
        for (int i = 0; i < runs.size() - 2; i++) {
            int[] left = runs.get(i);
            int[] mid = runs.get(i + 1);
            int[] right = runs.get(i + 2);
            
            // If left and right runs have the same character and the middle run has length 1
            if (left[0] == right[0] && mid[1] == 1) {
                int c = left[0];
                int combined = left[1] + right[1];
                
                // If there are more characters available outside this combined span, we can add 1
                if (count[c] > combined) {
                    maxLen = Math.max(maxLen, combined + 1);
                } else {
                    maxLen = Math.max(maxLen, combined);
                }
            }
        }
        
        return maxLen;
    }
}