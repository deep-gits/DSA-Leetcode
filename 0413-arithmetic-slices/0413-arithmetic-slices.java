class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        
        int n = nums.length;
        int totalCount = 0;
        int currentCount = 0;
        
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                currentCount++;
                totalCount += currentCount;
            } else {
                currentCount = 0;
            }
        }
        
        return totalCount;
    }
}