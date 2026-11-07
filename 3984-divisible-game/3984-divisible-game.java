class Solution {
    public int divisibleGame(int[] nums) {
        java.util.Set<Integer> primes = new java.util.HashSet<>();
        primes.add(2);
        
        for (int x : nums) {
            int temp = x;
            for (int p = 2; p * p <= temp; p++) {
                if (temp % p == 0) {
                    primes.add(p);
                    while (temp % p == 0) {
                        temp /= p;
                    }
                }
            }
            if (temp > 1) {
                primes.add(temp);
            }
        }
        
        long maxDiff = Long.MIN_VALUE;
        long bestK = Long.MAX_VALUE;
        
        for (int k : primes) {
            long currentMax = Long.MIN_VALUE;
            long currentSum = 0;
            
            for (int x : nums) {
                long val = (x % k == 0) ? x : -x;
                currentSum += val;
                if (currentSum > currentMax) {
                    currentMax = currentSum;
                }
                if (currentSum < 0) {
                    currentSum = 0;
                }
            }
            
            if (currentMax > maxDiff) {
                maxDiff = currentMax;
                bestK = k;
            } else if (currentMax == maxDiff && k < bestK) {
                bestK = k;
            }
        }
        
        long MOD = 1_000_000_007L;
        long prod = maxDiff * bestK;
        long ans = prod % MOD;
        if (ans < 0) {
            ans += MOD;
        }
        
        return (int) ans;
    }
}