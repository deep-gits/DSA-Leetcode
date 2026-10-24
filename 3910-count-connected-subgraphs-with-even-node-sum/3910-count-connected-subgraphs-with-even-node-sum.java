import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    private int vis;
    private int m;
    private List<Integer>[] g;

    public int evenSumSubgraphs(int[] nums, int[][] edges) {
        int n = nums.length;
        g = new ArrayList[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        
        int ans = 0;
        int limit = 1 << n;
        for (int sub = 1; sub < limit; sub++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (((sub >> i) & 1) == 1) {
                    sum += nums[i];
                }
            }
            if (sum % 2 != 0) {
                continue;
            }
            
            int start = -1;
            for (int i = 0; i < n; i++) {
                if (((sub >> i) & 1) == 1) {
                    start = i;
                    break;
                }
            }
            
            vis = 0;
            m = sub;
            dfs(start);
            
            if (vis == sub) {
                ans++;
            }
        }
        return ans;
    }

    private void dfs(int u) {
        vis |= (1 << u);
        for (int v : g[u]) {
            if (((m >> v) & 1) == 1 && ((vis >> v) & 1) == 0) {
                dfs(v);
            }
        }
    }
}