class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) {
            return result;
        }

        // Min-heap to store triples: {sum, index_in_nums1, index_in_nums2}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Initialize the heap with pairs formed by nums1[i] and nums2[0]
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[] { nums1[i] + nums2[0], i, 0 });
        }

        while (k > 0 && !minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int u = curr[1];
            int v = curr[2];

            result.add(Arrays.asList(nums1[u], nums2[v]));
            k--;

            // If there is a next element in nums2 for the current nums1[u], push it to the heap
            if (v + 1 < nums2.length) {
                minHeap.offer(new int[] { nums1[u] + nums2[v + 1], u, v + 1 });
            }
        }

        return result;
    }
}