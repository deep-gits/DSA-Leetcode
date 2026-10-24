import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[2];
        int count = 0; // Number of distinct values in this subtree
    }

    private List<Integer>[] adj;
    private int[] pathXor;
    private List<int[]>[] queryList;
    private int[] ans;

    public int[] kthSmallest(int[] par, int[] vals, int[][] queries) {
        int n = par.length;
        adj = new ArrayList[n];
        Arrays.setAll(adj, i -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            adj[par[i]].add(i);
        }

        pathXor = new int[n];
        computePathXor(0, 0, vals);

        queryList = new ArrayList[n];
        Arrays.setAll(queryList, i -> new ArrayList<>());
        for (int i = 0; i < queries.length; i++) {
            queryList[queries[i][0]].add(new int[]{queries[i][1], i});
        }

        ans = new int[queries.length];
        Arrays.fill(ans, -1);

        dfs(0);

        return ans;
    }

    private void computePathXor(int u, int parentXor, int[] vals) {
        pathXor[u] = parentXor ^ vals[u];
        for (int v : adj[u]) {
            computePathXor(v, pathXor[u], vals);
        }
    }

    private TrieNode dfs(int u) {
        TrieNode root = new TrieNode();
        insert(root, pathXor[u]);

        for (int v : adj[u]) {
            TrieNode childRoot = dfs(v);
            if (countNodes(childRoot) > countNodes(root)) {
                TrieNode temp = root;
                root = childRoot;
                childRoot = temp;
            }
            merge(root, childRoot);
        }

        if (!queryList[u].isEmpty()) {
            for (int[] q : queryList[u]) {
                int k = q[0];
                int idx = q[1];
                ans[idx] = findKth(root, k);
            }
        }

        return root;
    }

    private int countNodes(TrieNode node) {
        return node == null ? 0 : node.count;
    }

    private boolean contains(TrieNode root, int val) {
        TrieNode curr = root;
        for (int i = 16; i >= 0; i--) {
            int bit = (val >> i) & 1;
            if (curr.children[bit] == null) {
                return false;
            }
            curr = curr.children[bit];
        }
        return true;
    }

    private void insert(TrieNode root, int val) {
        if (contains(root, val)) return;
        TrieNode curr = root;
        curr.count++;
        for (int i = 16; i >= 0; i--) {
            int bit = (val >> i) & 1;
            if (curr.children[bit] == null) {
                curr.children[bit] = new TrieNode();
            }
            curr = curr.children[bit];
            curr.count++;
        }
    }

    private void merge(TrieNode dest, TrieNode src) {
        List<Integer> values = new ArrayList<>();
        collectValues(src, 0, 16, values);
        for (int val : values) {
            insert(dest, val);
        }
    }

    private void collectValues(TrieNode node, int currentVal, int bit, List<Integer> values) {
        if (node == null) return;
        if (bit < 0) {
            values.add(currentVal);
            return;
        }
        if (node.children[0] != null) {
            collectValues(node.children[0], currentVal, bit - 1, values);
        }
        if (node.children[1] != null) {
            collectValues(node.children[1], currentVal | (1 << bit), bit - 1, values);
        }
    }

    private int findKth(TrieNode root, int k) {
        TrieNode curr = root;
        int res = 0;
        for (int i = 16; i >= 0; i--) {
            int leftCount = countNodes(curr.children[0]);
            if (k <= leftCount) {
                curr = curr.children[0];
            } else {
                k -= leftCount;
                res |= (1 << i);
                curr = curr.children[1];
            }
            if (curr == null) return -1;
        }
        return res;
    }
}