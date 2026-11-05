class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] charMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            charMap[order.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            if (!compare(words[i], words[i + 1], charMap)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean compare(String w1, String w2, int[] charMap) {
        int len1 = w1.length();
        int len2 = w2.length();
        
        for (int i = 0; i < Math.min(len1, len2); i++) {
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(i);
            if (c1 != c2) {
                return charMap[c1 - 'a'] < charMap[c2 - 'a'];
            }
        }
        
        return len1 <= len2;
    }
}