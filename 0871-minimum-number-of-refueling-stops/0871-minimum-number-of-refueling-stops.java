class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // Max-heap to store the fuel capacities of stations we've passed
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        int currentFuel = startFuel;
        int prevPosition = 0;
        int stops = 0;
        
        for (int[] station : stations) {
            int position = station[0];
            int fuel = station[1];
            
            // Consume fuel to reach the current station
            currentFuel -= (position - prevPosition);
            
            // If we don't have enough fuel, refuel from the station with the most fuel passed so far
            while (currentFuel < 0 && !maxHeap.isEmpty()) {
                currentFuel += maxHeap.poll();
                stops++;
            }
            
            // If we still don't have enough fuel to reach this station, it's impossible
            if (currentFuel < 0) {
                return -1;
            }
            
            // Save this station's fuel in the max-heap and update our position
            maxHeap.offer(fuel);
            prevPosition = position;
        }
        
        // Finally, travel from the last station (or start) to the target
        currentFuel -= (target - prevPosition);
        while (currentFuel < 0 && !maxHeap.isEmpty()) {
            currentFuel += maxHeap.poll();
            stops++;
        }
        
        if (currentFuel < 0) {
            return -1;
        }
        
        return stops;
    }
}