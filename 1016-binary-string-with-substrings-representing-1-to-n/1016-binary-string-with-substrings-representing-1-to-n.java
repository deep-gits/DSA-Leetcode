class Solution {
    public boolean queryString(String s, int n) {
        // If n is large, it's impossible to contain all binary representations up to n
        // because the length of the string would need to be much larger.
        // Practically, if n > s.length() * 2, some binary strings of length ~log(n) won't fit.
        // More strictly, any binary representation > 2^10 or similar can be checked, but 
        // a simple optimization is to check numbers from n down to n/2 + 1.
        
        for (int i = n; i > n / 2; i--) {
            if (!s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        
        return true;
    }
}