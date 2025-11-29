class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            // If count falls to 0, we forget the old candidate and pick a new one
            if (count == 0) {
                candidate = num;
            }

            // If the current number is the candidate, vote for it (+1)
            // Otherwise, vote against it (-1)
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}