import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToBuses.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }
        
        if (!stopToBuses.containsKey(source) || !stopToBuses.containsKey(target)) {
            return -1;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visitedBuses = new boolean[routes.length];
        Set<Integer> visitedStops = new HashSet<>();
        
        queue.offer(source);
        visitedStops.add(source);
        int buses = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            buses++;
            for (int i = 0; i < size; i++) {
                int currStop = queue.poll();
                List<Integer> busesForStop = stopToBuses.get(currStop);
                if (busesForStop == null) {
                    continue;
                }
                
                for (int bus : busesForStop) {
                    if (visitedBuses[bus]) {
                        continue;
                    }
                    visitedBuses[bus] = true;
                    
                    for (int nextStop : routes[bus]) {
                        if (nextStop == target) {
                            return buses;
                        }
                        if (!visitedStops.contains(nextStop)) {
                            visitedStops.add(nextStop);
                            queue.offer(nextStop);
                        }
                    }
                }
            }
        }
        return -1;
    }
}