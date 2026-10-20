class Solution {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        return helper(str, 0, s.length(), k);
    }

    private int helper(char[] str, int start, int end, int k) {
        if (end - start < k) {
            return 0;
        }

        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            count[str[i] - 'a']++;
        }

        for (int i = start; i < end; i++) {
            if (count[str[i] - 'a'] < k) {
                int j = i + 1;
                while (j < end && count[str[j] - 'a'] < k) {
                    j++;
                }
                return Math.max(helper(str, start, i, k), helper(str, j, end, k));
            }
        }

        return end - start;
    }
}