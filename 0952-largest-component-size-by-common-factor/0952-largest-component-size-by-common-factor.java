class Solution {
    public int largestComponentSize(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        
        DSU dsu = new DSU(max + 1);
        for (int num : nums) {
            for (int factor = 2; factor * factor <= num; factor++) {
                if (num % factor == 0) {
                    dsu.union(num, factor);
                    dsu.union(num, num / factor);
                }
            }
        }
        
        int[] count = new int[max + 1];
        int maxComponent = 0;
        for (int num : nums) {
            int root = dsu.find(num);
            count[root]++;
            maxComponent = Math.max(maxComponent, count[root]);
        }
        
        return maxComponent;
    }
    
    class DSU {
        int[] parent;
        
        public DSU(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            return parent[i] = find(parent[i]);
        }
        
        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
            }
        }
    }
}