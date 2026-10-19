class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int noDeletion = arr[0];
        int oneDeletion = arr[0];
        int maxSoFar = arr[0];
        
        int prevNoDeletion = arr[0];
        int prevOneDeletion = arr[0];
        
        for (int i = 1; i < n; i++) {
            // max sum ending at i with no deletions
            noDeletion = Math.max(arr[i], prevNoDeletion + arr[i]);
            
            // max sum ending at i with at most one deletion:
            // either we deleted an element before (prevOneDeletion + arr[i]) 
            // or we are deleting the current element (prevNoDeletion)
            oneDeletion = Math.max(prevNoDeletion, prevOneDeletion + arr[i]);
            
            maxSoFar = Math.max(maxSoFar, Math.max(noDeletion, oneDeletion));
            
            prevNoDeletion = noDeletion;
            prevOneDeletion = oneDeletion;
        }
        
        return maxSoFar;
    }
}