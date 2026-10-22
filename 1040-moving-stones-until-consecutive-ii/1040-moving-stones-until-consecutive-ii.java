import java.util.Arrays;

class Solution {
    public int[] numMovesStonesII(int[] stones) {
        int n = stones.length;
        Arrays.sort(stones);
        
        // Maximum moves: determined by the total empty spaces available 
        // when sliding from either the left or the right endpoint inward.
        int maxMoves = Math.max(
            stones[n - 1] - stones[1] + 1 - (n - 1),
            stones[n - 2] - stones[0] + 1 - (n - 1)
        );
        
        // Minimum moves: using a sliding window of length n to find 
        // the maximum number of stones that can be grouped together.
        int minMoves = n;
        int i = 0;
        
        for (int j = 0; j < n; j++) {
            // Shrink the window if the span exceeds n positions
            while (stones[j] - stones[i] + 1 > n) {
                i++;
            }
            
            int alreadyCount = j - i + 1;
            
            // Special edge case: n - 1 stones are already consecutive, 
            // requiring 2 moves instead of 1 if the isolated stone is at the edge.
            if (alreadyCount == n - 1 && stones[j] - stones[i] + 1 == n - 1) {
                minMoves = Math.min(minMoves, 2);
            } else {
                minMoves = Math.min(minMoves, n - alreadyCount);
            }
        }
        
        return new int[] { minMoves, maxMoves };
    }
}