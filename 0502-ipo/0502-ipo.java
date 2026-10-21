class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        
        // Pair capital and profits together
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        
        // Sort projects by their capital requirements in ascending order
        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Max-heap to store the profits of available projects
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        int i = 0;
        for (int j = 0; j < k; j++) {
            // Push all affordable projects into the max-heap
            while (i < n && projects[i][0] <= w) {
                maxHeap.offer(projects[i][1]);
                i++;
            }
            
            // If no projects can be afforded, break out
            if (maxHeap.isEmpty()) {
                break;
            }
            
            // Select the project with the maximum profit
            w += maxHeap.poll();
        }
        
        return w;
    }
}