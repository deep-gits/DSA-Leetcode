class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    
    private int atMost(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        
        int left = 0;
        int oddCount = 0;
        int totalSubarrays = 0;
        
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0) {
                oddCount++;
            }
            
            while (oddCount > k) {
                if (nums[left] % 2 != 0) {
                    oddCount--;
                }
                left++;
            }
            
            totalSubarrays += (right - left + 1);
        }
        
        return totalSubarrays;
    }
}