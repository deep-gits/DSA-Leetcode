class Solution {
    public int[/* 2 */] smallestRange(List<List<Integer>> nums) {
        // Min-heap storing {element_value, list_index, element_index}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        int currentMax = Integer.MIN_VALUE;
        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;
        
        // Initialize the heap with the first element of each list
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new int[] { val, i, 0 });
            currentMax = Math.max(currentMax, val);
        }
        
        while (true) {
            int[] curr = minHeap.poll();
            int minVal = curr[0];
            int listIdx = curr[1];
            int elemIdx = curr[2];
            
            // Update the global best range if the current one is smaller
            if (currentMax - minVal < rangeEnd - rangeStart) {
                rangeStart = minVal;
                rangeEnd = currentMax;
            }
            
            // If we reach the end of any list, we can no longer cover all lists
            if (elemIdx + 1 == nums.get(listIdx).size()) {
                break;
            }
            
            // Move to the next element in the same list
            int nextVal = nums.get(listIdx).get(elemIdx + 1);
            minHeap.offer(new int[] { nextVal, listIdx, elemIdx + 1 });
            currentMax = Math.max(currentMax, nextVal);
        }
        
        return new int[] { rangeStart, rangeEnd };
    }
}