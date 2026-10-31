class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long mod = 1_000_000_007;
        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            for (int i = l; i <= r; i += k) {
                nums[i] = (int) ((1L * nums[i] * v) % mod);
            }
        }
        int ans = 0;
        for (int x : nums) {
            ans ^= x;
        }
        return ans;
    }
}