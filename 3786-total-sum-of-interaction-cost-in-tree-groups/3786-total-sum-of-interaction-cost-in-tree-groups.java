import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private List<Integer>[] g;
    private int[] group;
    private long totalCost = 0;
    private Map<Integer, Integer> totalCounts = new HashMap<>();
    private Map<Integer, Integer>[] counts;

    public long interactionCosts(int n, int[][] edges, int[] group) {
        this.group = group;
        g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        
        // Count total frequencies of each group in the entire tree
        for (int gId : group) {
            totalCounts.put(gId, totalCounts.getOrDefault(gId, 0) + 1);
        }

        counts = new HashMap[n];
        dfs(0, -1);
        return totalCost;
    }

    private void dfs(int u, int p) {
        counts[u] = new HashMap<>();
        counts[u].put(group[u], 1);

        for (int v : g[u]) {
            if (v != p) {
                dfs(v, u);
                
                // Add the edge contributions for each group in subtree v
                for (Map.Entry<Integer, Integer> entry : counts[v].entrySet()) {
                    int gId = entry.getKey();
                    int vCnt = entry.getValue();
                    int totalG = totalCounts.get(gId);
                    
                    // Contribution of edge between u and v for group gId
                    totalCost += (long) vCnt * (totalG - vCnt);
                }

                // Small-to-large merging for efficiency
                if (counts[v].size() > counts[u].size()) {
                    Map<Integer, Integer> temp = counts[u];
                    counts[u] = counts[v];
                    counts[v] = temp;
                }
                for (Map.Entry<Integer, Integer> entry : counts[v].entrySet()) {
                    int gId = entry.getKey();
                    int vCnt = entry.getValue();
                    counts[u].put(gId, counts[u].getOrDefault(gId, 0) + vCnt);
                }
            }
        }
    }
}