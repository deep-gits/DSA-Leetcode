class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;
        Set<Integer> setB = new HashSet<>();
        
        for (int x : aliceSizes) {
            sumA += x;
        }
        for (int x : bobSizes) {
            sumB += x;
            setB.add(x);
        }
        
        int diff = (sumA - sumB) / 2;
        for (int x : aliceSizes) {
            int target = x - diff;
            if (setB.contains(target)) {
                return new int[]{x, target};
            }
        }
        
        return new int[0];
    }
}