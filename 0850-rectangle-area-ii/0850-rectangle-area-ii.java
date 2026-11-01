import java.util.Arrays;

class Solution {
    public int rectangleArea(int[][] rectangles) {
        int MOD = 1_000_000_007;
        int n = rectangles.length;
        int[] xCoords = new int[2 * n];
        int idx = 0;
        for (int[] r : rectangles) {
            xCoords[idx++] = r[0];
            xCoords[idx++] = r[2];
        }
        Arrays.sort(xCoords);
        
        long totalArea = 0;
        for (int i = 0; i < xCoords.length - 1; i++) {
            int x1 = xCoords[i];
            int x2 = xCoords[i + 1];
            long width = x2 - x1;
            if (width == 0) continue;
            
            int[][] activeY = new int[n][2];
            int activeCount = 0;
            for (int[] r : rectangles) {
                if (r[0] <= x1 && r[2] >= x2) {
                    activeY[activeCount][0] = r[1];
                    activeY[activeCount][1] = r[3];
                    activeCount++;
                }
            }
            
            if (activeCount == 0) continue;
            
            int[][] intervals = new int[activeCount][2];
            for (int j = 0; j < activeCount; j++) {
                intervals[j][0] = activeY[j][0];
                intervals[j][1] = activeY[j][1];
            }
            
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            
            long currentHeight = 0;
            int startY = -1;
            int endY = -1;
            for (int[] interval : intervals) {
                if (interval[0] > endY) {
                    currentHeight += (endY - startY);
                    startY = interval[0];
                    endY = interval[1];
                } else {
                    endY = Math.max(endY, interval[1]);
                }
            }
            currentHeight += (endY - startY);
            
            totalArea = (totalArea + width * currentHeight) % MOD;
        }
        return (int) totalArea;
    }
}