class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0) {
            return res;
        }
        
        if (k > 0) {
            int currentSum = 0;
            for (int i = 1; i <= k; i++) {
                currentSum += code[i % n];
            }
            for (int i = 0; i < n; i++) {
                res[i] = currentSum;
                currentSum -= code[(i + 1) % n];
                currentSum += code[(i + 1 + k) % n];
            }
        } else {
            k = -k;
            int currentSum = 0;
            for (int i = n - k; i < n; i++) {
                currentSum += code[i % n];
            }
            for (int i = 0; i < n; i++) {
                res[i] = currentSum;
                currentSum -= code[(n - k + i) % n];
                currentSum += code[i % n];
            }
        }
        
        return res;
    }
}