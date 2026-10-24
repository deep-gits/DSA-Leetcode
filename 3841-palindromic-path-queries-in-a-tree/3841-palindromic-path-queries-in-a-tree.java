import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<Integer>[] g;
    private int[] parent, depth, heavy, head, pos, size;
    private int curPos;
    private int[] tree;
    private int[] val;
    private int n;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        parent = new int[n];
        depth = new int[n];
        heavy = new int[n];
        Arrays.fill(heavy, -1);
        head = new int[n];
        pos = new int[n];
        size = new int[n];

        dfs1(0, -1, 0);
        curPos = 0;
        dfs2(0, 0);

        val = new int[n];
        for (int i = 0; i < n; i++) {
            val[pos[i]] = 1 << (s.charAt(i) - 'a');
        }

        tree = new int[4 * n];
        build(1, 0, n - 1);

        List<Boolean> ans = new ArrayList<>();
        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                int mask = 1 << (parts[2].charAt(0) - 'a');
                val[pos[u]] = mask;
                update(1, 0, n - 1, pos[u], mask);
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int mask = queryPath(u, v);
                ans.add(mask == 0 || (mask & (mask - 1)) == 0);
            }
        }
        return ans;
    }

    private int dfs1(int u, int p, int d) {
        parent[u] = p;
        depth[u] = d;
        size[u] = 1;
        int maxSub = 0;
        for (int v : g[u]) {
            if (v != p) {
                int sub = dfs1(v, u, d + 1);
                size[u] += sub;
                if (sub > maxSub) {
                    maxSub = sub;
                    heavy[u] = v;
                }
            }
        }
        return size[u];
    }

    private void dfs2(int u, int h) {
        head[u] = h;
        pos[u] = curPos++;
        if (heavy[u] != -1) {
            dfs2(heavy[u], h);
        }
        for (int v : g[u]) {
            if (v != parent[u] && v != heavy[u]) {
                dfs2(v, v);
            }
        }
    }

    private void build(int node, int l, int r) {
        if (l == r) {
            tree[node] = val[l];
            return;
        }
        int mid = (l + r) / 2;
        build(2 * node, l, mid);
        build(2 * node + 1, mid + 1, r);
        tree[node] = tree[2 * node] ^ tree[2 * node + 1];
    }

    private void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            tree[node] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (idx <= mid) {
            update(2 * node, l, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, r, idx, val);
        }
        tree[node] = tree[2 * node] ^ tree[2 * node + 1];
    }

    private int query(int node, int l, int r, int ql, int qr) {
        if (ql > r || qr < l) {
            return 0;
        }
        if (ql <= l && r <= qr) {
            return tree[node];
        }
        int mid = (l + r) / 2;
        return query(2 * node, l, mid, ql, qr) ^ query(2 * node + 1, mid + 1, r, ql, qr);
    }

    private int queryPath(int u, int v) {
        int res = 0;
        while (head[u] != head[v]) {
            if (depth[head[u]] < depth[head[v]]) {
                int temp = u; u = v; v = temp;
            }
            res ^= query(1, 0, n - 1, pos[head[u]], pos[u]);
            u = parent[head[u]];
        }
        if (depth[u] > depth[v]) {
            int temp = u; u = v; v = temp;
        }
        res ^= query(1, 0, n - 1, pos[u], pos[v]);
        return res;
    }
}