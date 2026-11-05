class Solution {
    public int sumSubseqWidths(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long mod = 1_000_000_007;
        long ans = 0;
        long p = 1;
        
        long[] pow2 = new long[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % mod;
        }
        
        for (int i = 0; i < n; i++) {
            ans = (ans + (pow2[i] - pow2[n - 1 - i]) * nums[i]) % mod;
        }
        
        return (int)((ans + mod) % mod);
    }
}