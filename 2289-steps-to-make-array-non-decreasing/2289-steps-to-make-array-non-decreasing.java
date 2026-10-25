import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                dp[i] = Math.max(dp[i] + 1, dp[stack.pop()]);
                ans = Math.max(ans, dp[i]);
            }
            stack.push(i);
        }

        return ans;
    }
}