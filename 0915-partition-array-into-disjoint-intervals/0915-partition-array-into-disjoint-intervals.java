class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int leftMax = nums[0];
        int maxSoFar = nums[0];
        int partitionIdx = 0;
        
        for (int i = 1; i < n; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            if (nums[i] < leftMax) {
                leftMax = maxSoFar;
                partitionIdx = i;
            }
        }
        
        return partitionIdx + 1;
    }
}