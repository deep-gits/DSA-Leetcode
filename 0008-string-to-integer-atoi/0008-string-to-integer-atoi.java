class Solution {
    public int myAtoi(String s) {
        // Step 1: Trim leading and trailing whitespaces
        s = s.trim();
        if (s.isEmpty()) return 0;

        // Step 2: Initialize variables
        int sign = 1, index = 0, n = s.length();
        long result = 0;

        // Step 3: Handle optional sign
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // Step 4: Convert characters to digits
        while (index < n && Character.isDigit(s.charAt(index))) {
            result = result * 10 + (s.charAt(index) - '0');
            if (result * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (result * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            index++;
        }

        // Step 5: Return the final result
        return (int) (result * sign);
    }
}
