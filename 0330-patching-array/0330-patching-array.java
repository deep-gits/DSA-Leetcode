class Solution {
    public int minPatches(int[] nums, int n) {
        long missing = 1;
        int patches = 0;
        int i = 0;
        int len = nums.length;

        while (missing <= n) {
            if (i < len && nums[i] <= missing) {
                missing += nums[i];
                i++;
            } else {
                missing += missing;
                patches++;
            }
        }

        return patches;
    }
}