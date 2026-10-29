class Solution {
    public int findMinMoves(int[] machines) {
        int total = 0;
        for (int m : machines) {
            total += m;
        }
        int n = machines.length;
        if (total % n != 0) {
            return -1;
        }
        int target = total / n;
        int sum = 0;
        int maxMoves = 0;
        for (int i = 0; i < n; i++) {
            int diff = machines[i] - target;
            sum += diff;
            maxMoves = Math.max(maxMoves, Math.max(Math.abs(sum), diff));
        }
        return maxMoves;
    }
}