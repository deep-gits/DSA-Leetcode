class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-heap based on squared distance from origin (x^2 + y^2)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1]))
        );
        
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        int[][] result = new int[k][2];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        
        return result;
    }
}