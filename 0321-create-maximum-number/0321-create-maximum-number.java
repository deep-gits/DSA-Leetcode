class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] best = new int[k];

        for (int i = Math.max(0, k - m); i <= Math.min(k, n); i++) {
            int[] sub1 = maxArray(nums1, i);
            int[] sub2 = maxArray(nums2, k - i);
            int[] candidate = merge(sub1, sub2, k);
            if (greater(candidate, 0, best, 0)) {
                best = candidate;
            }
        }

        return best;
    }

    private int[] maxArray(int[] nums, int k) {
        int[] res = new int[k];
        int len = nums.length;
        for (int i = 0, j = 0; i < len; i++) {
            while (len - i + j > k && j > 0 && res[j - 1] < nums[i]) {
                j--;
            }
            if (j < k) {
                res[j++] = nums[i];
            }
        }
        return res;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int i = 0, j = 0, r = 0;
        while (r < k) {
            if (greater(nums1, i, nums2, j)) {
                res[r++] = nums1[i++];
            } else {
                res[r++] = nums2[j++];
            }
        }
        return res;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}