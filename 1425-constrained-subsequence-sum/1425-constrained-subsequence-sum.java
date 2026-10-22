import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window [i - k, i - 1]
            if (!deque.isEmpty() && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }
            
            // dp[i] is nums[i] plus the maximum valid previous dp value (if positive)
            dp[i] = nums[i];
            if (!deque.isEmpty() && dp[deque.peekFirst()] > 0) {
                dp[i] += dp[deque.peekFirst()];
            }
            
            // Maintain a decreasing monotonic deque
            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
            maxSum = Math.max(maxSum, dp[i]);
        }
        
        return maxSum;
    }
}