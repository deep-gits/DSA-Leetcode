import java.util.Arrays;

class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        int n = nums.length;
        long ans = 0;
        for (int i = n - 1; i >= n - k; i--) {
            ans += (long) nums[i] * Math.max(1, mul);
            mul--;
        }
        return ans;
    }
}