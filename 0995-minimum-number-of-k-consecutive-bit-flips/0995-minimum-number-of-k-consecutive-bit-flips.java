class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] flipped = new int[n];
        int currentFlips = 0;
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            // Remove the effect of a flip that is now out of the window size k
            if (i >= k) {
                currentFlips ^= flipped[i - k];
            }
            
            // If the effective bit is 0, we must flip starting at index i
            if ((nums[i] ^ currentFlips) == 0) {
                if (i + k > n) {
                    return -1;
                }
                flipped[i] = 1;
                currentFlips ^= 1;
                ans++;
            }
        }
        
        return ans;
    }
}