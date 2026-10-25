import java.util.TreeSet;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        long[] vals = new long[n];
        for (int i = 0; i < n; i++) {
            vals[i] = nums[i];
        }

        int[] prev = new int[n];
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        TreeSet<long[]> pq = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });

        int unsortedCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (vals[i] > vals[i + 1]) {
                unsortedCount++;
            }
            pq.add(new long[]{vals[i] + vals[i + 1], i});
        }

        if (unsortedCount == 0) return 0;

        int operations = 0;

        while (unsortedCount > 0 && !pq.isEmpty()) {
            long[] top = pq.pollFirst();
            long sum = top[0];
            int u = (int) top[1];

            int v = next[u];
            if (v == -1 || vals[u] + vals[v] != sum) {
                continue;
            }

            int p = prev[u];
            int w = next[v];

            if (p != -1 && vals[p] > vals[u]) unsortedCount--;
            if (vals[u] > vals[v]) unsortedCount--;
            if (w != -1 && vals[v] > vals[w]) unsortedCount--;

            if (p != -1) {
                pq.remove(new long[]{vals[p] + vals[u], p});
            }
            if (w != -1) {
                pq.remove(new long[]{vals[v] + vals[w], v});
            }

            vals[u] += vals[v];
            next[u] = w;
            if (w != -1) {
                prev[w] = u;
            }

            if (p != -1 && vals[p] > vals[u]) unsortedCount++;
            if (w != -1 && vals[u] > vals[w]) unsortedCount++;

            operations++;

            if (p != -1) {
                pq.add(new long[]{vals[p] + vals[u], p});
            }
            if (w != -1) {
                pq.add(new long[]{vals[u] + vals[w], u});
            }
        }

        return operations;
    }
}