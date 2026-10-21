class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Map to store graph: node -> list of {neighbor, weight}
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] time : times) {
            adj.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[] { time[1], time[2] });
        }

        // Min-heap storing {distance_from_k, current_node}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[] { 0, k });

        // Distance map to track the shortest time to reach each node
        Map<Integer, Integer> distances = new HashMap<>();

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int currDist = curr[0];
            int u = curr[1];

            if (distances.containsKey(u)) {
                continue;
            }
            distances.put(u, currDist);

            if (adj.containsKey(u)) {
                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0];
                    int weight = neighbor[1];

                    if (!distances.containsKey(v)) {
                        minHeap.offer(new int[] { currDist + weight, v });
                    }
                }
            }
        }

        if (distances.size() != n) {
            return -1;
        }

        int maxWaitTime = 0;
        for (int dist : distances.values()) {
            maxWaitTime = Math.max(maxWaitTime, dist);
        }

        return maxWaitTime;
    }
}