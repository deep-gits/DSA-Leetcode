import java.util.Arrays;

class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] nDigits = getSortedDigits(n);
        for (int i = 0; i < 31; i++) {
            int p = 1 << i;
            if (Arrays.equals(nDigits, getSortedDigits(p))) {
                return true;
            }
        }
        return false;
    }

    private char[] getSortedDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        Arrays.sort(digits);
        return digits;
    }
}