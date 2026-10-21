class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        int max = 0, letter = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                letter = i;
            }
        }
        
        if (max > (s.length() + 1) / 2) {
            return "";
        }
        
        char[] res = new char[s.length()];
        int idx = 0;
        
        // Place the most frequent character first at even indices
        while (count[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            count[letter]--;
        }
        
        // Place the remaining characters
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                count[i]--;
            }
        }
        
        return new String(res);
    }
}