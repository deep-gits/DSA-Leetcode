class Solution {
    public int scheduleCourse(int[][] courses) {
        // Sort courses by their deadline in ascending order
        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int totalDuration = 0;
        
        for (int[] course : courses) {
            int duration = course[0];
            int deadline = course[1];
            
            if (totalDuration + duration <= deadline) {
                totalDuration += duration;
                maxHeap.offer(duration);
            } else if (!maxHeap.isEmpty() && maxHeap.peek() > duration) {
                totalDuration += duration - maxHeap.poll();
                maxHeap.offer(duration);
            }
        }
        
        return maxHeap.size();
    }
}