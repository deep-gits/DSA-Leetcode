import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<Integer>[] g;
    private int[] good;
    private int[] subScore;
    private int[] ans;

    public int[] maxSubgraphScore(int n, int[][] edges, int[] good) {
        this.good = good;
        g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        
        subScore = new int[n];
        ans = new int[n];
        
        dfs1(0, -1);
        dfs2(0, -1, 0);
        
        return ans;
    }

    private void dfs1(int u, int p) {
        int val = (good[u] == 1) ? 1 : -1;
        for (int v : g[u]) {
            if (v != p) {
                dfs1(v, u);
                if (subScore[v] > 0) {
                    val += subScore[v];
                }
            }
        }
        subScore[u] = val;
    }

    private void dfs2(int u, int p, int parentScore) {
        int val = (good[u] == 1) ? 1 : -1;
        int total = val + (parentScore > 0 ? parentScore : 0);
        for (int v : g[u]) {
            if (v != p) {
                if (subScore[v] > 0) {
                    total += subScore[v];
                }
            }
        }
        ans[u] = total;

        for (int v : g[u]) {
            if (v != p) {
                int withoutV = total - (subScore[v] > 0 ? subScore[v] : 0);
                dfs2(v, u, withoutV);
            }
        }
    }
}