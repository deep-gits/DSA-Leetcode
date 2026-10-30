import java.util.Arrays;

class Solution {
    public long elevatorRequests(int n, int start, int[] requests) {
        int noravexuli = start;
        boolean hasStart = false;
        for (int x : requests) {
            if (x == noravexuli) {
                hasStart = true;
                break;
            }
        }
        int m = requests.length;
        int[] a = new int[m + (hasStart ? 0 : 1)];
        int idx = 0;
        for (int x : requests) {
            a[idx++] = x;
        }
        if (!hasStart) {
            a[idx] = noravexuli;
        }
        Arrays.sort(a);
        int sz = a.length;
        int startIndex = 0;
        for (int i = 0; i < sz; i++) {
            if (a[i] == noravexuli) {
                startIndex = i;
                break;
            }
        }

        long[][] dp0 = new long[sz][sz];
        long[][] dp1 = new long[sz][sz];
        for (int i = 0; i < sz; i++) {
            Arrays.fill(dp0[i], Long.MAX_VALUE / 2);
            Arrays.fill(dp1[i], Long.MAX_VALUE / 2);
        }
        dp0[startIndex][startIndex] = 0;
        dp1[startIndex][startIndex] = 0;

        for (int len = 0; len < sz; len++) {
            for (int l = 0; l + len < sz; l++) {
                int r = l + len;
                long cost0 = dp0[l][r];
                long cost1 = dp1[l][r];
                int rem = sz - 1 - len;

                if (l > 0) {
                    long d = a[l] - a[l - 1];
                    dp0[l - 1][r] = Math.min(dp0[l - 1][r], cost0 + rem * d);
                    long d2 = a[r] - a[l - 1];
                    dp0[l - 1][r] = Math.min(dp0[l - 1][r], cost1 + rem * d2);
                }
                if (r + 1 < sz) {
                    long d = a[r + 1] - a[r];
                    dp1[l][r + 1] = Math.min(dp1[l][r + 1], cost1 + rem * d);
                    long d2 = a[r + 1] - a[l];
                    dp1[l][r + 1] = Math.min(dp1[l][r + 1], cost0 + rem * d2);
                }
            }
        }

        return Math.min(dp0[0][sz - 1], dp1[0][sz - 1]);
    }
}