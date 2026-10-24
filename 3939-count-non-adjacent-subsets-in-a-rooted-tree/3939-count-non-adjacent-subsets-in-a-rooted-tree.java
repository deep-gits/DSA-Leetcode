import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    private static final int MOD = 1_000_000_007;
    private List<Integer>[] children;
    private int[] nums;
    private int k;

    public int countValidSubsets(int[] parent, int[] nums, int k) {
        int n = parent.length;
        this.nums = nums;
        this.k = k;
        children = new ArrayList[n];
        Arrays.setAll(children, i -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }
        long[][] rootRes = dfs(0);
        long total = (rootRes[0][0] + rootRes[1][0]) % MOD;
        return (int) ((total - 1 + MOD) % MOD);
    }

    private long[][] dfs(int u) {
        long[] dp0 = new long[k];
        long[] dp1 = new long[k];
        dp0[0] = 1;
        dp1[nums[u] % k] = 1;

        for (int v : children[u]) {
            long[][] childRes = dfs(v);
            long[] cSum = new long[k];
            for (int i = 0; i < k; i++) {
                cSum[i] = (childRes[0][i] + childRes[1][i]) % MOD;
            }

            long[] nextDp0 = new long[k];
            long[] nextDp1 = new long[k];

            for (int i = 0; i < k; i++) {
                if (dp0[i] == 0) {
                    continue;
                }
                for (int j = 0; j < k; j++) {
                    int rem = (i + j) % k;
                    nextDp0[rem] = (nextDp0[rem] + dp0[i] * cSum[j]) % MOD;
                }
            }

            for (int i = 0; i < k; i++) {
                if (dp1[i] == 0) {
                    continue;
                }
                for (int j = 0; j < k; j++) {
                    int rem = (i + j) % k;
                    nextDp1[rem] = (nextDp1[rem] + dp1[i] * childRes[0][j]) % MOD;
                }
            }

            dp0 = nextDp0;
            dp1 = nextDp1;
        }

        return new long[][] { dp0, dp1 };
    }
}