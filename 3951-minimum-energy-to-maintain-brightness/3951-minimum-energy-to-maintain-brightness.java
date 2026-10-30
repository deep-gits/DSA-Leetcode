import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] x = intervals[i];
            int[] last = merged.get(merged.size() - 1);
            if (last[1] < x[0]) {
                merged.add(x);
            } else {
                last[1] = Math.max(last[1], x[1]);
            }
        }
        long ans = 0;
        long perPointEnergy = (brightness + 2L) / 3;
        for (int[] interval : merged) {
            long m = (long) interval[1] - interval[0] + 1;
            ans += perPointEnergy * m;
        }
        return ans;
    }
}