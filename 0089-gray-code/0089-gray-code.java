class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new java.util.ArrayList<>();
        int total = 1 << n;
        for (int i = 0; i < total; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }
}