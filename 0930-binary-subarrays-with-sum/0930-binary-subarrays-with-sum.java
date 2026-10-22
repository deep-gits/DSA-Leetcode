class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    
    private int atMost(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }
        
        int left = 0;
        int sum = 0;
        int count = 0;
        
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            
            count += (right - left + 1);
        }
        
        return count;
    }
}