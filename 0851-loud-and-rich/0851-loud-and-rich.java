class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        java.util.List<java.util.List<Integer>> graph = new java.util.ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new java.util.ArrayList<>());
        }
        for (int[] r : richer) {
            graph.get(r[1]).add(r[0]);
        }
        
        int[] memo = new int[n];
        java.util.Arrays.fill(memo, -1);
        
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = dfs(i, graph, quiet, memo);
        }
        return ans;
    }
    
    private int dfs(int node, java.util.List<java.util.List<Integer>> graph, int[] quiet, int[] memo) {
        if (memo[node] != -1) {
            return memo[node];
        }
        int res = node;
        for (int neighbor : graph.get(node)) {
            int candidate = dfs(neighbor, graph, quiet, memo);
            if (quiet[candidate] < quiet[res]) {
                res = candidate;
            }
        }
        return memo[node] = res;
    }
}