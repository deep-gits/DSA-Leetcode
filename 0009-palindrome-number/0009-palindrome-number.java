class Solution {
    public boolean isPalindrome(int x) {
        // As before, handle edge cases:
        // 1. Negative numbers are not palindromes.
        // 2. If the last digit is 0, the first digit must also be 0. 
        //    This is only true for the number 0 itself.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        // This loop runs until we've processed half of the digits.
        // We know we're halfway when the original number (x) becomes
        // smaller than or equal to the new revertedNumber.
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // After the loop, we have two cases:
        // 1. For even-length numbers (like 1221), x will be 12 and revertedNumber will be 12.
        //    So we check: x == revertedNumber
        // 2. For odd-length numbers (like 12321), x will be 12 and revertedNumber will be 123.
        //    The middle digit (3) doesn't matter, so we remove it from revertedNumber
        //    by dividing by 10. Then we check: x == revertedNumber / 10
        return x == revertedNumber || x == revertedNumber / 10;
    }
}