class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int currentSum = 0;
        
        // Take the first k cards from the left
        for (int i = 0; i < k; i++) {
            currentSum += cardPoints[i];
        }
        
        int maxSum = currentSum;
        
        // Slide the window: successively replace cards from the left window 
        // with cards from the end of the array.
        for (int i = 0; i < k; i++) {
            currentSum = currentSum - cardPoints[k - 1 - i] + cardPoints[n - 1 - i];
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}