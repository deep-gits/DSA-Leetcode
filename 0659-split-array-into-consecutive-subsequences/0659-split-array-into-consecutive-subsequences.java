class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Integer> appendMap = new HashMap<>();
        
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        for (int num : nums) {
            if (freqMap.get(num) == 0) {
                continue;
            }
            
            // Check if this number can be appended to an existing subsequence
            if (appendMap.getOrDefault(num, 0) > 0) {
                appendMap.put(num, appendMap.get(num) - 1);
                appendMap.put(num + 1, appendMap.getOrDefault(num + 1, 0) + 1);
            } 
            // Otherwise, start a new subsequence of length 3: [num, num + 1, num + 2]
            else if (freqMap.getOrDefault(num + 1, 0) > 0 && freqMap.getOrDefault(num + 2, 0) > 0) {
                freqMap.put(num + 1, freqMap.get(num + 1) - 1);
                freqMap.put(num + 2, freqMap.get(num + 2) - 1);
                appendMap.put(num + 3, appendMap.getOrDefault(num + 3, 0) + 1);
            } 
            else {
                return false;
            }
            
            freqMap.put(num, freqMap.get(num) - 1);
        }
        
        return true;
    }
}