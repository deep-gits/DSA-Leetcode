class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int target = totalSum - x;
        if (target < 0) {
            return -1;
        }
        if (target == 0) {
            return nums.length;
        }
        
        int n = nums.length;
        int left = 0;
        int currentSum = 0;
        int maxLen = -1;
        
        for (int right = 0; right < n; right++) {
            currentSum += nums[right];
            
            while (currentSum > target) {
                currentSum -= nums[left];
                left++;
            }
            
            if (currentSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        
        return maxLen == -1 ? -1 : n - maxLen;
    }
}