import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            map.put(row, map.getOrDefault(row, 0) | (1 << col));
        }

        int maxFamilies = n * 2;

        for (int mask : map.values()) {
            maxFamilies -= 2; 

            boolean left = (mask & 60) == 0;
            boolean right = (mask & 960) == 0;
            boolean middle = (mask & 240) == 0;

            if (left && right) {
                maxFamilies += 2;
            } else if (left || right || middle) {
                maxFamilies += 1;
            }
        }

        return maxFamilies;
    }
}