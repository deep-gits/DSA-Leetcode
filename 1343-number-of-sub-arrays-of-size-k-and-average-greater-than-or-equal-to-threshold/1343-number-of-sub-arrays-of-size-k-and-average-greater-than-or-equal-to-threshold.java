class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        long targetSum = (long) k * threshold;
        long currentSum = 0;
        int count = 0;
        
        // Initialize the first window of size k
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }
        
        if (currentSum >= targetSum) {
            count++;
        }
        
        // Slide the window across the rest of the array
        for (int i = k; i < n; i++) {
            currentSum += arr[i] - arr[i - k];
            if (currentSum >= targetSum) {
                count++;
            }
        }
        
        return count;
    }
}