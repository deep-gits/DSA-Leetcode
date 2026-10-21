class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Distance array to store the minimum cost to reach each node
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        // Perform Bellman-Ford up to k + 1 steps (k stops means at most k + 1 edges)
        for (int i = 0; i <= k; i++) {
            int[] tempPrices = prices.clone();

            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int cost = flight[2];

                if (prices[u] != Integer.MAX_VALUE) {
                    tempPrices[v] = Math.min(tempPrices[v], prices[u] + cost);
                }
            }
            prices = tempPrices;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}