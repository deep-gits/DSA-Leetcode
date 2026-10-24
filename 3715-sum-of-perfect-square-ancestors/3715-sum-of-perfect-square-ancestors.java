import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<Integer>[] g;
    private int[] nums;
    private long totalSum = 0;
    private int[] coreCounts;

    public long sumOfAncestors(int n, int[][] edges, int[] nums) {
        this.nums = nums;
        g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        
        // Find maximum value in nums to size the coreCounts array appropriately
        int maxVal = 0;
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }
        
        coreCounts = new int[maxVal + 1];
        dfs(0, -1);
        return totalSum;
    }

    private int getSquareFreeCore(int x) {
        int res = 1;
        for (int i = 2; i * i <= x; i++) {
            int count = 0;
            while (x % i == 0) {
                x /= i;
                count++;
            }
            if (count % 2 != 0) {
                res *= i;
            }
        }
        if (x > 1) {
            res *= x;
        }
        return res;
    }

    private void dfs(int u, int p) {
        int core = getSquareFreeCore(nums[u]);
        totalSum += coreCounts[core];
        
        coreCounts[core]++;
        for (int v : g[u]) {
            if (v != p) {
                dfs(v, u);
            }
        }
        coreCounts[core]--;
    }
}