class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        for (int x : arr) {
            Set<Integer> nxt = new HashSet<>();
            nxt.add(x);
            for (int y : cur) {
                nxt.add(x | y);
            }
            cur = nxt;
            ans.addAll(cur);
        }
        return ans.size();
    }
}