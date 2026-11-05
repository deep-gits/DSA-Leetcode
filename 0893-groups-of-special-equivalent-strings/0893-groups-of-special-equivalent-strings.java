class Solution {
    public int numSpecialEquivGroups(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            int[] odd = new int[26];
            int[] even = new int[26];
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {
                    even[word.charAt(i) - 'a']++;
                } else {
                    odd[word.charAt(i) - 'a']++;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(even[i]).append('#');
            }
            sb.append('|');
            for (int i = 0; i < 26; i++) {
                sb.append(odd[i]).append('#');
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}