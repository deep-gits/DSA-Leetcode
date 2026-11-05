class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        
        for (int targetSize = n; targetSize > 1; targetSize--) {
            int maxIdx = findMaxIndex(arr, targetSize);
            
            if (maxIdx == targetSize - 1) {
                continue;
            }
            
            if (maxIdx != 0) {
                result.add(maxIdx + 1);
                flip(arr, maxIdx + 1);
            }
            
            result.add(targetSize);
            flip(arr, targetSize);
        }
        
        return result;
    }
    
    private int findMaxIndex(int[] arr, int k) {
        int maxIdx = 0;
        for (int i = 1; i < k; i++) {
            if (arr[i] > arr[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }
    
    private void flip(int[] arr, int k) {
        int left = 0, right = k - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}