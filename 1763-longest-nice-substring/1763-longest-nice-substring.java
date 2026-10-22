class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) {
            return "";
        }
        
        char[] chars = s.toCharArray();
        boolean[] present = new boolean[128];
        for (char c : chars) {
            present[c] = true;
        }
        
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isLowerCase(c) && !present[Character.toUpperCase(c)] ||
                Character.isUpperCase(c) && !present[Character.toLowerCase(c)]) {
                String left = longestNiceSubstring(s.substring(0, i));
                String right = longestNiceSubstring(s.substring(i + 1));
                return left.length() >= right.length() ? left : right;
            }
        }
        
        return s;
    }
}