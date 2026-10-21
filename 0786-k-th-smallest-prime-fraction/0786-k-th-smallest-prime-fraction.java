class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Double.compare((double) arr[a[0]] / arr[a[1]], (double) arr[b[0]] / arr[b[1]])
        );

        for (int j = 1; j < n; j++) {
            minHeap.offer(new int[] { 0, j });
        }

        for (int i = 0; i < k - 1; i++) {
            int[] curr = minHeap.poll();
            int numIdx = curr[0];
            int denIdx = curr[1];

            if (numIdx + 1 < denIdx) {
                minHeap.offer(new int[] { numIdx + 1, denIdx });
            }
        }

        int[] result = minHeap.poll();
        return new int[] { arr[result[0]], arr[result[1]] };
    }
}