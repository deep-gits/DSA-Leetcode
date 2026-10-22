class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        // minLen[i] stores the minimum length of a subarray with sum `target` in arr[0...i]
        int[] minLen = new int[n];
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        int currentMin = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            
            // Shrink window if sum exceeds target (all elements are positive integers)
            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            
            if (sum == target) {
                int len = right - left + 1;
                
                // If there is a valid non-overlapping subarray ending at or before index `left - 1`
                if (left > 0 && minLen[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, len + minLen[left - 1]);
                }
                
                currentMin = Math.min(currentMin, len);
            }
            
            // Propagate the minimum length found so far up to index `right`
            minLen[right] = currentMin;
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}