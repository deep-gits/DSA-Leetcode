class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        boolean[] seen = new boolean[10001];
        int left = 0;
        int currentSum = 0;
        int maxSum = 0;
        
        for (int right = 0; right < nums.length; right++) {
            while (seen[nums[right]]) {
                seen[nums[left]] = false;
                currentSum -= nums[left];
                left++;
            }
            
            seen[nums[right]] = true;
            currentSum += nums[right];
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}