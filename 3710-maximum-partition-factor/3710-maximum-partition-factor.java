import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int maxPartitionFactor(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return 0;
        }
        
        List<Integer> uniqueDists = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                uniqueDists.add(dist);
            }
        }
        
        List<Integer> sortedDists = new ArrayList<>(new HashSet<>(uniqueDists));
        Collections.sort(sortedDists);
        
        int left = 0, right = sortedDists.size() - 1;
        int ans = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int threshold = sortedDists.get(mid);
            if (canPartition(n, points, threshold)) {
                ans = threshold;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }
    
    private boolean canPartition(int n, int[][] points, int threshold) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                if (dist < threshold) {
                    g[i].add(j);
                    g[j].add(i);
                }
            }
        }
        
        int[] color = new int[n];
        Arrays.fill(color, -1);
        
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                
                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (int v : g[u]) {
                        if (color[v] == -1) {
                            color[v] = 1 - color[u];
                            q.offer(v);
                        } else if (color[v] == color[u]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}