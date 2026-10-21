class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] workers = new double[n][2];
        
        for (int i = 0; i < n; i++) {
            workers[i][0] = (double) wage[i] / quality[i]; // wage-to-quality ratio
            workers[i][1] = quality[i];
        }
        
        // Sort workers by their ratio in ascending order
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        
        double minCost = Double.MAX_VALUE;
        int qualitySum = 0;
        
        // Max-heap to keep track of the largest qualities among the chosen k workers
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (double[] worker : workers) {
            double ratio = worker[0];
            int q = (int) worker[1];
            
            qualitySum += q;
            maxHeap.offer(q);
            
            if (maxHeap.size() > k) {
                qualitySum -= maxHeap.poll();
            }
            
            if (maxHeap.size() == k) {
                minCost = Math.min(minCost, qualitySum * ratio);
            }
        }
        
        return minCost;
    }
}