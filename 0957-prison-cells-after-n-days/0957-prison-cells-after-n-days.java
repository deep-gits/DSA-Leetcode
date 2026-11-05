class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<String, Integer> seen = new HashMap<>();
        boolean fastForwarded = false;
        
        for (int i = 0; i < n; i++) {
            String key = Arrays.toString(cells);
            if (!fastForwarded && seen.containsKey(key)) {
                int cycleLength = i - seen.get(key);
                int remaining = (n - 1 - i) % cycleLength;
                i = n - 1 - remaining;
                fastForwarded = true;
            } else {
                seen.put(key, i);
            }
            cells = nextDay(cells);
        }
        return cells;
    }
    
    private int[] nextDay(int[] cells) {
        int[] next = new int[8];
        for (int i = 1; i < 7; i++) {
            if (cells[i - 1] == cells[i + 1]) {
                next[i] = 1;
            } else {
                next[i] = 0;
            }
        }
        return next;
    }
}