class Solution {
    public int rob(int[] nums) {

        int rob1 = 0;
        int rob2 = 0;

        for (int num : nums) {
            int temp = Math.max(num + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }
}