import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(word);
        }
        
        String[] words = paragraph.toLowerCase().replaceAll("[^a-z]", " ").split("\\s+");
        Map<String, Integer> count = new HashMap<>();
        
        String ans = "";
        int maxCount = 0;
        
        for (String word : words) {
            if (!word.isEmpty() && !bannedSet.contains(word)) {
                count.put(word, count.getOrDefault(word, 0) + 1);
                if (count.get(word) > maxCount) {
                    maxCount = count.get(word);
                    ans = word;
                }
            }
        }
        
        return ans;
    }
}