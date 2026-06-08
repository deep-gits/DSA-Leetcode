class Solution {

    public int findTheCity(
            int n,
            int[][] edges,
            int distanceThreshold) {

        int[][] dist =
                new int[n][n];

        for (int i = 0; i < n; i++) {

            Arrays.fill(
                dist[i],
                Integer.MAX_VALUE / 2
            );

            dist[i][i] = 0;
        }

        for (int[] e : edges) {

            dist[e[0]][e[1]] = e[2];
            dist[e[1]][e[0]] = e[2];
        }

        for (int k = 0; k < n; k++) {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    dist[i][j] =
                        Math.min(
                            dist[i][j],
                            dist[i][k]
                            +
                            dist[k][j]
                        );
                }
            }
        }

        int city = -1;
        int minReachable = n;

        for (int i = 0; i < n; i++) {

            int reachable = 0;

            for (int j = 0; j < n; j++) {

                if (
                    dist[i][j]
                    <=
                    distanceThreshold
                ) {
                    reachable++;
                }
            }

            if (reachable <= minReachable) {

                minReachable = reachable;
                city = i;
            }
        }

        return city;
    }
}