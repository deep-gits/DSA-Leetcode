class Solution {
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        Set<String> set = new HashSet<>();
        for (int[] p : points) {
            set.add(p[0] + "," + p[1]);
        }
        
        double minArea = Double.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    int x3 = points[k][0], y3 = points[k][1];
                    
                    if ((x3 - x1) * (x2 - x1) + (y3 - y1) * (y2 - y1) == 0) {
                        int x4 = x3 + x2 - x1;
                        int y4 = y3 + y2 - y1;
                        
                        if (set.contains(x4 + "," + y4)) {
                            double area = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) * 
                                          Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
                            minArea = Math.min(minArea, area);
                        }
                    }
                }
            }
        }
        
        return minArea == Double.MAX_VALUE ? 0 : minArea;
    }
}