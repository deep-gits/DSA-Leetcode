class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int m = n - k + 1;
        
        // Step 1: Compute the sum of all subarrays of length k
        int[] w = new int[m];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i >= k) {
                sum -= nums[i - k];
            }
            if (i >= k - 1) {
                w[i - k + 1] = sum;
            }
        }
        
        // Step 2: Precompute the best starting index on the left for each position
        int[] left = new int[m];
        int best = 0;
        for (int i = 0; i < m; i++) {
            if (w[i] > w[best]) {
                best = i;
            }
            left[i] = best;
        }
        
        // Step 3: Precompute the best starting index on the right for each position
        int[] right = new int[m];
        best = m - 1;
        for (int i = m - 1; i >= 0; i--) {
            if (w[i] >= w[best]) {
                best = i;
            }
            right[i] = best;
        }
        
        // Step 4: Iterate over all possible middle subarray starting indices and find the maximum sum
        int[] result = new int[] { -1, -1, -1 };
        int maxSum = 0;
        
        // Ensure j + k < m so that the right subarray index (j + k) never goes out of bounds
        for (int j = k; j <= m - k - 1; j++) {
            int i = left[j - k];
            int l = right[j + k];
            int total = w[i] + w[j] + w[l];
            
            if (total > maxSum) {
                maxSum = total;
                result = new int[] { i, j, l };
            }
        }
        
        return result;
    }
}