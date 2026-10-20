class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int prevValue = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = 0;
            switch (s.charAt(i)) {
                case 'I': currentValue = 1; break;
                case 'V': currentValue = 5; break;
                case 'X': currentValue = 10; break;
                case 'L': currentValue = 50; break;
                case 'C': currentValue = 100; break;
                case 'D': currentValue = 500; break;
                case 'M': currentValue = 1000; break;
            }
            
            if (currentValue < prevValue) {
                sum -= currentValue;
            } else {
                sum += currentValue;
            }
            prevValue = currentValue;
        }
        
        return sum;
    }
}