class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int longest = 1;
        // equivalent to unordered_set<int> st;
        Set<Integer> st = new HashSet<>();

        // Adding elements to the set
        for (int i = 0; i < n; i++) {
            st.add(nums[i]);
        }

        // Iterating through the set
        for (int it : st) {
            // equivalent to st.find(it - 1) == st.end()
            if (!st.contains(it - 1)) {
                int cnt = 1;
                int x = it;

                // equivalent to st.find(x + 1) != st.end()
                while (st.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }

                longest = Math.max(longest, cnt);
            }
        }

        return longest;
    }
}