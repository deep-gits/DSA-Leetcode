class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cnt = edge[2];
            adj.computeIfAbsent(u, x -> new ArrayList<>()).add(new int[] { v, cnt + 1 });
            adj.computeIfAbsent(v, x -> new ArrayList<>()).add(new int[] { u, cnt + 1 });
        }

        // Max-heap storing {moves_remaining, current_node}
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        maxHeap.offer(new int[] { maxMoves, 0 });

        Map<Integer, Integer> visited = new HashMap<>();
        Map<String, Integer> used = new HashMap<>(); // "u#v" -> nodes reached from u along edge (u,v)

        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int moves = curr[0];
            int u = curr[1];

            if (visited.containsKey(u)) {
                continue;
            }
            visited.put(u, moves);

            if (adj.containsKey(u)) {
                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0];
                    int weight = neighbor[1];

                    int reachable = Math.min(moves, weight - 1);
                    used.put(u + "#" + v, reachable);

                    int nextMoves = moves - weight;
                    if (nextMoves >= 0 && !visited.containsKey(v)) {
                        maxHeap.offer(new int[] { nextMoves, v });
                    }
                }
            }
        }

        int totalReachable = visited.size();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cnt = edge[2];

            int uUsed = used.getOrDefault(u + "#" + v, 0);
            int vUsed = used.getOrDefault(v + "#" + u, 0);

            totalReachable += Math.min(cnt, uUsed + vUsed);
        }

        return totalReachable;
    }
}