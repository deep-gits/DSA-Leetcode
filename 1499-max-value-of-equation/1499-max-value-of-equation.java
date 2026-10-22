import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int maxValue = Integer.MIN_VALUE;
        
        for (int j = 0; j < points.length; j++) {
            int xj = points[j][0];
            int yj = points[j][1];
            
            while (!deque.isEmpty() && xj - points[deque.peekFirst()][0] > k) {
                deque.pollFirst();
            }
            
            if (!deque.isEmpty()) {
                int i = deque.peekFirst();
                int xi = points[i][0];
                int yi = points[i][1];
                maxValue = Math.max(maxValue, yi + yj + xj - xi);
            }
            
            while (!deque.isEmpty() && (points[deque.peekLast()][1] - points[deque.peekLast()][0]) <= (yj - xj)) {
                deque.pollLast();
            }
            
            deque.offerLast(j);
        }
        
        return maxValue;
    }
}
