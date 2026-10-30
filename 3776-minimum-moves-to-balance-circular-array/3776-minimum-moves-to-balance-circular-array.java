class Solution {
    public long minMoves(int[] balance) {
        long sum = 0;
        int n = balance.length;
        for (int x : balance) {
            sum += x;
        }
        if (sum < 0) {
            return -1;
        }
        int mn = balance[0];
        int idx = 0;
        for (int i = 1; i < n; i++) {
            if (balance[i] < mn) {
                mn = balance[i];
                idx = i;
            }
        }
        if (mn >= 0) {
            return 0;
        }
        long need = -mn;
        long ans = 0;
        for (int j = 1; j < n; j++) {
            int a = balance[(idx - j + n) % n];
            int b = balance[(idx + j) % n];
            long c1 = Math.min(a, need);
            need -= c1;
            ans += c1 * j;
            if (need == 0) {
                break;
            }
            long c2 = Math.min(b, need);
            need -= c2;
            ans += c2 * j;
            if (need == 0) {
                break;
            }
        }
        return ans;
    }
}