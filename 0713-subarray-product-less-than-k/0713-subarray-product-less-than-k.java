class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        
        int n = nums.length;
        int count = 0;
        long product = 1L; // Use long to prevent overflow before division
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            product *= nums[right];
            
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            
            // All subarrays ending at 'right' and starting from 'left' to 'right' are valid
            count += (right - left + 1);
        }
        
        return count;
    }
}