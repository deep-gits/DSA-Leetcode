class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 1;
        
        boolean[] higher = new boolean[n];
        boolean[] lower = new boolean[n];
        higher[n - 1] = true;
        lower[n - 1] = true;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n - 1], n - 1);
        
        int count = 1;
        
        for (int i = n - 2; i >= 0; i--) {
            int val = arr[i];
            
            Integer nextHigherKey = map.ceilingKey(val);
            Integer nextLowerKey = map.floorKey(val);
            
            if (nextHigherKey != null) {
                higher[i] = lower[map.get(nextHigherKey)];
            }
            
            if (nextLowerKey != null) {
                lower[i] = higher[map.get(nextLowerKey)];
            }
            
            if (higher[i]) {
                count++;
            }
            
            map.put(val, i);
        }
        
        return count;
    }
}