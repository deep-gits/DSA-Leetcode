class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        for (int num : nums) {
            // XOR accumulates the single number
            // and cancels out duplicates
            result = result ^ num;
        }
        
        return result;
    }
}