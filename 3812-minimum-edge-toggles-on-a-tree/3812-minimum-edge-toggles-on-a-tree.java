import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    private List<int[]>[] g;
    private List<Integer> ans;
    private String start, target;

    public List<Integer> minimumFlips(int n, int[][] edges, String start, String target) {
        this.start = start;
        this.target = target;
        g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 0; i < n - 1; ++i) {
            int a = edges[i][0], b = edges[i][1];
            g[a].add(new int[] {b, i});
            g[b].add(new int[] {a, i});
        }
        ans = new ArrayList<>();
        if (dfs(0, -1)) {
            return List.of(-1);
        }
        Collections.sort(ans);
        return ans;
    }

    private boolean dfs(int a, int fa) {
        boolean rev = start.charAt(a) != target.charAt(a);
        for (var e : g[a]) {
            int b = e[0], i = e[1];
            if (b != fa && dfs(b, a)) {
                ans.add(i);
                rev = !rev;
            }
        }
        return rev;
    }
}