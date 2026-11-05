class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];
        count[0] = 1;
        int prefixSum = 0, ans = 0;
        for (int x : nums) {
            prefixSum = (prefixSum + x % k + k) % k;
            ans += count[prefixSum];
            count[prefixSum]++;
        }
        return ans;
    }
}