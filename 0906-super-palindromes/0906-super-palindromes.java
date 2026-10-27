class Solution {
    public int superpalindromesInRange(String leftStr, String rightStr) {
        long left = Long.parseLong(leftStr);
        long right = Long.parseLong(rightStr);
        int count = 0;

        for (int L = 1; L <= 9; L++) {
            int len = (L + 1) / 2;
            long min = (long) Math.pow(10, len - 1);
            long max = (long) Math.pow(10, len) - 1;

            for (long i = min; i <= max; i++) {
                long p = generatePalindrome(i, L % 2 == 0);
                long sq = p * p;
                if (sq > right) break;
                if (sq >= left && isPalindrome(sq)) {
                    count++;
                }
            }
        }
        return count;
    }

    private long generatePalindrome(long i, boolean even) {
        long p = i;
        if (even) {
            long temp = i;
            while (temp > 0) {
                p = p * 10 + temp % 10;
                temp /= 10;
            }
        } else {
            long temp = i / 10;
            while (temp > 0) {
                p = p * 10 + temp % 10;
                temp /= 10;
            }
        }
        return p;
    }

    private boolean isPalindrome(long x) {
        long rev = 0;
        long temp = x;
        while (temp > 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }
        return x == rev;
    }
}