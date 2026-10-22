class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length < 2 || indexDiff <= 0) {
            return false;
        }
        
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long num = (long) nums[i];
            
            // Find the smallest element in the set greater than or equal to num - valueDiff
            Long ceiling = set.ceiling(num - valueDiff);
            if (ceiling != null && ceiling <= num + valueDiff) {
                return true;
            }
            
            set.add(num);
            
            // Maintain the sliding window of size indexDiff
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }
        
        return false;
    }
}