class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        
        int count = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        
        for (int i = 2; i <= n && i <= 10; i++) {
            uniqueDigits *= availableNumber;
            count += uniqueDigits;
            availableNumber--;
        }
        
        return count;
    }
}