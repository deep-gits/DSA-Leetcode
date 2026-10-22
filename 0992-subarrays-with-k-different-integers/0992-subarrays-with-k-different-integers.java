class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    
    private int atMostK(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[n + 1];
        int left = 0;
        int distinctCount = 0;
        int totalCount = 0;
        
        for (int right = 0; right < n; right++) {
            if (freq[nums[right]] == 0) {
                distinctCount++;
            }
            freq[nums[right]]++;
            
            while (distinctCount > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    distinctCount--;
                }
                left++;
            }
            
            totalCount += (right - left + 1);
        }
        
        return totalCount;
    }
}