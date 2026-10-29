import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int n = nums.length;
        int left = (n - 1) / 2;
        int right = n - 1;
        
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = temp[left--];
            } else {
                nums[i] = temp[right--];
            }
        }
    }
}