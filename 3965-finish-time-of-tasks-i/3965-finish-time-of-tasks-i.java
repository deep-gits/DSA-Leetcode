import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    private List<Integer>[] g;
    private int[] baseTime;

    public long finishTime(int n, int[][] edges, int[] baseTime) {
        this.baseTime = baseTime;
        g = new ArrayList[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
        }
        return dfs(0);
    }

    private long dfs(int i) {
        if (g[i].isEmpty()) {
            return baseTime[i];
        }
        long earliest = Long.MAX_VALUE;
        long latest = Long.MIN_VALUE;
        for (int j : g[i]) {
            long a = dfs(j);
            earliest = Math.min(earliest, a);
            latest = Math.max(latest, a);
        }
        long ownDuration = (latest - earliest) + baseTime[i];
        return latest + ownDuration;
    }
}