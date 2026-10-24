import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

class Solution {
    private int[] parent;

    private int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        parent = new int[c + 1];
        for (int i = 1; i <= c; i++) {
            parent[i] = i;
        }

        for (int[] conn : connections) {
            union(conn[0], conn[1]);
        }

        TreeSet<Integer>[] sets = new TreeSet[c + 1];
        Arrays.setAll(sets, k -> new TreeSet<>());

        for (int i = 1; i <= c; i++) {
            sets[find(i)].add(i);
        }

        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];
            int root = find(x);

            if (type == 1) {
                if (sets[root].contains(x)) {
                    ans.add(x);
                } else {
                    if (sets[root].isEmpty()) {
                        ans.add(-1);
                    } else {
                        ans.add(sets[root].first());
                    }
                }
            } else {
                sets[root].remove(x);
            }
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}