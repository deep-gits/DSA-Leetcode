import java.util.Arrays;

class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;
        long totalPairs = (long) n * (n - 1) / 2;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        long disjoint = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && ends[j] < starts[i]) {
                j++;
            }
            disjoint += j;
        }
        return totalPairs - disjoint;
    }
}