class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxB = new int[26];
        for (String b : words2) {
            int[] count = new int[26];
            for (char c : b.toCharArray()) {
                count[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                maxB[i] = Math.max(maxB[i], count[i]);
            }
        }
        
        List<String> ans = new ArrayList<>();
        for (String a : words1) {
            int[] count = new int[26];
            for (char c : a.toCharArray()) {
                count[c - 'a']++;
            }
            boolean valid = true;
            for (int i = 0; i < 26; i++) {
                if (count[i] < maxB[i]) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                ans.add(a);
            }
        }
        return ans;
    }
}