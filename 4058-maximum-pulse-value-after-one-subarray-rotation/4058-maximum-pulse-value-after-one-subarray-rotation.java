class Solution {
    public long maxValue(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(
                (long) nums[0] - nums[1],
                (long) nums[1] - nums[0]
            );
        }
        
        long total = 0;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 1) {
                total -= nums[i];
            } else {
                total += nums[i];
            }
        }
        
        long maxSum = Math.max(total, total - 2L * (nums[0] - nums[1]));
        long maxEvenPrefixSum = nums[0];
        long maxOddPrefixSum = Math.max(0L, (long) nums[0] - nums[1]);
        long sum = (long) nums[0] - nums[1];
        
        for (int i = 2; i < n; i++) {
            if ((i & 1) == 1) {
                sum -= nums[i];
                maxSum = Math.max(maxSum, total - 2L * (sum - maxOddPrefixSum));
                maxOddPrefixSum = Math.max(maxOddPrefixSum, sum);
            } else {
                sum += nums[i];
                maxSum = Math.max(maxSum, total - 2L * (sum - maxEvenPrefixSum));
                maxEvenPrefixSum = Math.max(maxEvenPrefixSum, sum);
            }
        }
        
        return maxSum;
    }
}