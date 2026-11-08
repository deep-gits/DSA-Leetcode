class Solution {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (char c : order.toCharArray()) {
            while (count[c - 'a'] > 0) {
                sb.append(c);
                count[c - 'a']--;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                sb.append((char) (i + 'a'));
                count[i]--;
            }
        }
        
        return sb.toString();
    }
}