class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        int minLength = Integer.MAX_VALUE;
        Deque<Integer> deque = new LinkedList<>(); // stores indices of prefixSum
        
        for (int j = 0; j <= n; j++) {
            // Remove from the front of the deque while the sum condition is satisfied
            while (!deque.isEmpty() && prefixSum[j] - prefixSum[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, j - deque.pollFirst());
            }
            
            // Maintain monotonic increasing order in the deque
            while (!deque.isEmpty() && prefixSum[j] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }
            
            deque.offerLast(j);
        }
        
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}