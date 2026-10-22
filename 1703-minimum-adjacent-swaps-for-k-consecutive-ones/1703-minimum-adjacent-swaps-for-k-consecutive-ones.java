class Solution {
    public int minMoves(int[] nums, int k) {
        java.util.List<Integer> ones = new java.util.ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                ones.add(i - ones.size());
            }
        }
        
        int m = ones.size();
        long[] prefixSum = new long[m + 1];
        for (int i = 0; i < m; i++) {
            prefixSum[i + 1] = prefixSum[i] + ones.get(i);
        }
        
        long minMoves = Long.MAX_VALUE;
        int radius = k / 2;
        
        for (int i = 0; i <= m - k; i++) {
            int j = i + k - 1;
            int mid = i + radius;
            long median = ones.get(mid);
            
            long leftCost = median * (mid - i) - (prefixSum[mid] - prefixSum[i]);
            long rightCost = (prefixSum[j + 1] - prefixSum[mid + 1]) - median * (j - mid);
            
            minMoves = Math.min(minMoves, leftCost + rightCost);
        }
        
        return (int) minMoves;
    }
}