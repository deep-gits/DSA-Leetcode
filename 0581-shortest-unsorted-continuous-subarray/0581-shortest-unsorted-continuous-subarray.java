class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int right = -1;

        for (int i = 1; i < n; i++) {
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }
        }

        int min = nums[n - 1];
        int left = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > min) {
                left = i;
            } else {
                min = nums[i];
            }
        }

        return right == -1 ? 0 : right - left + 1;
    }
}