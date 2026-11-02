class Solution {
    public int[] constructArray(int n, int k) {
        int[] answer = new int[n];
        int left = 1, right = n;
        int idx = 0;
        for (int i = 0; i < k; ++i) {
            if (i % 2 == 0) {
                answer[idx++] = left++;
            } else {
                answer[idx++] = right--;
            }
        }
        if (k % 2 == 0) {
            for (int i = right; i >= left; --i) {
                answer[idx++] = i;
            }
        } else {
            for (int i = left; i <= right; ++i) {
                answer[idx++] = i;
            }
        }
        return answer;
    }
}