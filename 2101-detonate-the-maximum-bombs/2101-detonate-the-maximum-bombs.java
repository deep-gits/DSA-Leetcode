import java.util.*;

class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long r1 = bombs[i][2];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                long x2 = bombs[j][0];
                long y2 = bombs[j][1];
                long distSq = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
                if (distSq <= r1 * r1) {
                    graph[i].add(j);
                }
            }
        }
        
        int maxBombs = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            dfs(graph, i, visited);
            maxBombs = Math.max(maxReg(maxBombs, visited.size()), maxBombs);
        }
        
        return maxBombs;
    }
    
    private void dfs(List<Integer>[] graph, int u, Set<Integer> visited) {
        visited.add(u);
        for (int v : graph[u]) {
            if (!visited.contains(v)) {
                dfs(graph, v, visited);
            }
        }
    }
    
    private int maxReg(int a, int b) {
        return Math.max(a, b);
    }
}