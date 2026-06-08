class Solution {

    public boolean validPath(
            int n,
            int[][] edges,
            int source,
            int destination) {

        List<List<Integer>> graph =
                new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(
                new ArrayList<>()
            );
        }

        for (int[] edge : edges) {

            graph.get(edge[0])
                 .add(edge[1]);

            graph.get(edge[1])
                 .add(edge[0]);
        }

        boolean[] visited =
                new boolean[n];

        return dfs(
            source,
            destination,
            graph,
            visited
        );
    }

    private boolean dfs(
            int node,
            int destination,
            List<List<Integer>> graph,
            boolean[] visited) {

        if (node == destination)
            return true;

        visited[node] = true;

        for (int next :
                graph.get(node)) {

            if (
                !visited[next]
                &&
                dfs(
                    next,
                    destination,
                    graph,
                    visited
                )
            ) {
                return true;
            }
        }

        return false;
    }
}