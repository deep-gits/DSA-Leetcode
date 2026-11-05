class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>();
        Map<String, String> lowerWords = new HashMap<>();
        Map<String, String> vowelWords = new HashMap<>();
        
        for (String word : wordlist) {
            exactWords.add(word);
            
            String lower = word.toLowerCase();
            lowerWords.putIfAbsent(lower, word);
            
            String devowelized = devowel(lower);
            vowelWords.putIfAbsent(devowelized, word);
        }
        
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exactWords.contains(q)) {
                result[i] = q;
            } else {
                String lower = q.toLowerCase();
                if (lowerWords.containsKey(lower)) {
                    result[i] = lowerWords.get(lower);
                } else {
                    String devowelized = devowel(lower);
                    result[i] = vowelWords.getOrDefault(devowelized, "");
                }
            }
        }
        
        return result;
    }
    
    private String devowel(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}