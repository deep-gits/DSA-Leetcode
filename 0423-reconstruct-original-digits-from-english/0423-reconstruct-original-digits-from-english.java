class Solution {
    public String originalDigits(String s) {
        int[] count = new int[10];
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'z') count[0]++;
            if (c == 'w') count[2]++;
            if (c == 'u') count[4]++;
            if (c == 'x') count[6]++;
            if (c == 'g') count[8]++;
            
            if (c == 'h') count[3]++; // 'h' is in 'three' and 'eight'
            if (c == 'f') count[5]++; // 'f' is in 'five' and 'four'
            if (c == 's') count[7]++; // 's' is in 'seven' and 'six'
            if (c == 'i') count[9]++; // 'i' is in 'nine', 'five', 'six', 'eight'
            if (c == 'n') count[1]++; // 'n' is in 'one', 'seven', 'nine'
        }
        
        // Derive unique counts step by step
        count[3] -= count[8];                   // three = h - eight
        count[5] -= count[4];                   // five = f - four
        count[7] -= count[6];                   // seven = s - six
        count[9] = count[9] - count[5] - count[6] - count[8]; // nine = i - five - six - eight
        count[1] = count[1] - count[7] - count[9] * 2;       // one = n - seven - two*nine (since 'seven' has 1 'n' and 'nine' has 2 'n's)
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append(i);
            }
        }
        
        return sb.toString();
    }
}