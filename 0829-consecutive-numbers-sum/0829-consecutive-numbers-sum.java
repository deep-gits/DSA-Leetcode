class Solution {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        for (int k = 1; (long) k * (k - 1) / 2 < n; k++) {
            long numerator = n - (long) k * (k - 1) / 2;
            if (numerator % k == 0) {
                count++;
            }
        }
        return count;
    }
}