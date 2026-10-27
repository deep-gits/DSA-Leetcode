class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int res = 0;
        int i = 0;
        
        while (i < n) {
            int j = i;
            while (j + 1 < n && arr[j] < arr[j + 1]) {
                j++;
            }
            if (j == i) {
                i++;
                continue;
            }
            
            int peak = j;
            while (j + 1 < n && arr[j] > arr[j + 1]) {
                j++;
            }
            if (j == peak) {
                i++;
                continue;
            }
            
            res = Math.max(res, j - i + 1);
            i = j;
        }
        
        return res;
    }
}