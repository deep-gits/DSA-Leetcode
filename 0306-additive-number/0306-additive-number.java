import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        if (n < 3) {
            return false;
        }

        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(0) == '0' && i > 0) {
                break;
            }
            long num1 = Long.parseLong(num.substring(0, i + 1));
            
            for (int j = i + 1; n - 1 - j >= Math.max(i + 1 - 0, j - i); j++) {
                if (num.charAt(i + 1) == '0' && j > i + 1) {
                    break;
                }
                long num2 = Long.parseLong(num.substring(i + 1, j + 1));
                
                if (isValid(num1, num2, j + 1, num)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    private boolean isValid(long num1, long num2, int k, String num) {
        int n = num.length();
        while (k < n) {
            long sum = num1 + num2;
            String sumStr = Long.toString(sum);
            
            if (!num.startsWith(sumStr, k)) {
                return false;
            }
            
            k += sumStr.length();
            num1 = num2;
            num2 = sum;
        }
        return true;
    }
}