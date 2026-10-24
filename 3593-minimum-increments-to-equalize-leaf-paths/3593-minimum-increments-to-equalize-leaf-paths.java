import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private List<Integer>[] g;
    private int[] cost;
    private int ans = 0;

    public int minIncrease(int n, int[][] edges, int[] cost) {
        this.cost = cost;
        g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        dfs(0, -1);
        return ans;
    }

    private long dfs(int u, int p) {
        long maxChildPath = 0;
        List<Long> childPaths = new ArrayList<>();
        boolean isLeaf = true;

        for (int v : g[u]) {
            if (v != p) {
                isLeaf = false;
                long cp = dfs(v, u);
                childPaths.add(cp);
                maxChildPath = Math.max(maxChildPath, cp);
            }
        }

        if (isLeaf) {
            return cost[u];
        }

        // Check if all child path sums are equal to maxChildPath
        // If any child path is strictly less than maxChildPath, we need to increment nodes in that subtree.
        // To minimize the number of nodes changed, we can see if a single node increment higher up or specific nodes can cover it, 
        // or if we must increment distinct nodes.
        for (long cp : childPaths) {
            if (cp < maxChildPath) {
                // If paths are unequal, we need to increment nodes. 
                // Wait, if multiple children have different paths, we count how many paths need boosting.
            }
        }

        // Let's group children by their path sums or handle discrepancies.
        // If children have different path sums, say max is M, and another is S, 
        // we must increase something in the subtree of S by (M - S). 
        // Does that require 1 node or more? Increasing 1 node by (M - S) counts as 1 node whose cost is increased!
        // Wait, if we increase the root of that child subtree, it's 1 node. Let's check if we can just increment 
        // the node itself or if we need to count unique node operations.
        
        long sumDiff = 0;
        boolean needsAdjustment = false;
        for (long cp : childPaths) {
            if (cp != maxChildPath) {
                needsAdjustment = true;
            }
        }

        if (needsAdjustment) {
            // Each branch that doesn't match the maximum needs its own node incremented at the top of that branch 
            // if we want to minimize the number of nodes (we just pick 1 node per deficient branch).
            for (long cp : childPaths) {
                if (cp < maxChildPath) {
                    ans++;
                }
            }
        }

        return cost[u] + maxChildPath;
    }
}