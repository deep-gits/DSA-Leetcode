class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        long MOD = 1_000_000_007;
        java.util.Arrays.sort(arr);
        java.util.Map<Integer, Long> dp = new java.util.HashMap<>();
        
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            long count = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int right = arr[i] / arr[j];
                    if (dp.containsKey(right)) {
                        count = (count + dp.get(arr[j]) * dp.get(right)) % MOD;
                    }
                }
            }
            dp.put(arr[i], count);
            ans = (ans + count) % MOD;
        }
        
        return (int) ans;
    }
}