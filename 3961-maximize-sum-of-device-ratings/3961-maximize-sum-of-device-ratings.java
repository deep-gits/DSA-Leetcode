import java.util.Arrays;

class Solution {
    public long maxRatings(int[][] units) {
        int m = units.length;
        int n = units[0].length;
        if (n == 1) {
            long ans = 0;
            for (int[] x : units) {
                ans += x[0];
            }
            return ans;
        }
        for (int[] x : units) {
            Arrays.sort(x);
        }
        Arrays.sort(units, (a, b) -> Integer.compare(a[1], b[1]));
        long ret = 0;
        int kick = Integer.MAX_VALUE;
        for (int i = 1; i < m; i++) {
            ret += units[i][1];
            kick = Math.min(kick, units[i][0]);
        }
        return ret + Math.min(units[0][0], kick);
    }
}