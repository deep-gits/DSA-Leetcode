class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;
        
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            
            // Shrink the window from the left if there are more than 1 zeros
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            
            // Since we must delete exactly one element, the length of the 
            // remaining contiguous 1's in the current window is (right - left + 1) - 1 = right - left.
            maxLength = Math.max(maxLength, right - left);
        }
        
        return maxLength;
    }
}