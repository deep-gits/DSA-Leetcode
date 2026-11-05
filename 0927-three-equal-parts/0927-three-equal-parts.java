class Solution {
    public int[] threeEqualParts(int[] arr) {
        int totalOnes = 0;
        for (int x : arr) {
            if (x == 1) totalOnes++;
        }
        if (totalOnes == 0) {
            return new int[]{0, arr.length - 1};
        }
        if (totalOnes % 3 != 0) {
            return new int[]{-1, -1};
        }
        
        int targetOnes = totalOnes / 3;
        int i1 = -1, i2 = -1, i3 = -1;
        int count = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                if (count == 1) i1 = i;
                if (count == targetOnes + 1) i2 = i;
                if (count == 2 * targetOnes + 1) i3 = i;
            }
        }
        
        int n = arr.length;
        while (i3 < n) {
            if (arr[i1] == arr[i2] && arr[i2] == arr[i3]) {
                i1++;
                i2++;
                i3++;
            } else {
                return new int[]{-1, -1};
            }
        }
        
        return new int[]{i1 - 1, i2};
    }
}