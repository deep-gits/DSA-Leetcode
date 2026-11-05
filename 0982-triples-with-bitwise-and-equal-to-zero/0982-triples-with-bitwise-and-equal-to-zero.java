class Solution {
    public int countTriplets(int[] nums) {
        int[] count = new int[1 << 16];
        for (int x : nums) {
            for (int y : nums) {
                count[x & y]++;
            }
        }
        
        int ans = 0;
        for (int z : nums) {
            for (int i = 0; i < (1 << 16); i++) {
                if ((i & z) == 0) {
                    ans += count[i];
                }
            }
        }
        
        return ans;
    }
}