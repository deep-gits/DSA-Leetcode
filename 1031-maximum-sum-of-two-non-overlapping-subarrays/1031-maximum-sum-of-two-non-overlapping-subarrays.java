class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        // Test both configurations:
        // 1. firstLen subarray appears before secondLen subarray
        // 2. secondLen subarray appears before firstLen subarray
        return Math.max(
            getMaxSum(nums, firstLen, secondLen),
            getMaxSum(nums, secondLen, firstLen)
        );
    }
    
    private int getMaxSum(int[] nums, int L, int M) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        int maxL = 0;
        int maxSum = 0;
        
        // i represents the end index of the second subarray (M)
        for (int i = L + M; i <= n; i++) {
            // Subarray of length L ends at i - M
            int sumL = prefixSum[i - M] - prefixSum[i - M - L];
            // Subarray of length M ends at i
            int sumM = prefixSum[i] - prefixSum[i - M];
            
            maxL = Math.max(maxL, sumL);
            maxSum = Math.max(maxSum, maxL + sumM);
        }
        
        return maxSum;
    }
}