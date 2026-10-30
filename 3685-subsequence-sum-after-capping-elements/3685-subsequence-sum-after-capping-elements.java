import java.util.Arrays;

class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        boolean[] result = new boolean[n];
        boolean[] dp = new boolean[k + 1];
        dp[0] = true;
        int i = 0;
        for (int x = 1; x <= n; x++) {
            while (i < n && nums[i] < x) {
                for (int j = k; j >= nums[i]; j--) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
                i++;
            }
            int minJ = Math.max(0, k - (n - i) * x);
            for (int j = k; j >= minJ; j -= x) {
                if (dp[j]) {
                    result[x - 1] = true;
                    break;
                }
            }
        }
        return result;
    }
}