class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int left = 0;
        int n = s.length();
        int total = 0;
        
        for (int right = 0; right < n; right++) {
            count[s.charAt(right) - 'a']++;
            
            // Once the window contains at least one 'a', 'b', and 'c',
            // all substrings starting at `left` and ending from `right` to `n - 1` are valid.
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                total += (n - right);
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }
        
        return total;
    }
}