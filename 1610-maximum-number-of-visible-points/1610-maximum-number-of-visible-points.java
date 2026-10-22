import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int posX = location.get(0);
        int posY = location.get(1);
        int sameLocationCount = 0;
        List<Double> angles = new ArrayList<>();
        
        for (List<Integer> p : points) {
            int x = p.get(0) - posX;
            int y = p.get(1) - posY;
            
            if (x == 0 && y == 0) {
                sameLocationCount++;
                continue;
            }
            
            double rad = Math.atan2(y, x);
            double deg = Math.toDegrees(rad);
            angles.add(deg);
        }
        
        Collections.sort(angles);
        
        int n = angles.size();
        List<Double> extendedAngles = new ArrayList<>(angles);
        for (double deg : angles) {
            extendedAngles.add(deg + 360.0);
        }
        
        int maxVisible = 0;
        int left = 0;
        
        for (int right = 0; right < extendedAngles.size(); right++) {
            while (extendedAngles.get(right) - extendedAngles.get(left) > angle) {
                left++;
            }
            maxVisible = Math.max(maxVisible, right - left + 1);
        }
        
        return maxVisible + sameLocationCount;
    }
}