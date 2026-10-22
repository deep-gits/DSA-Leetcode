import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int slidingPuzzle(int[][] board) {
        StringBuilder start = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                start.append(board[i][j]);
            }
        }

        String target = "123450";
        String startStr = start.toString();

        if (startStr.equals(target)) {
            return 0;
        }

        int[][] neighbors = {
            {1, 3},
            {0, 2, 4},
            {1, 5},
            {0, 4},
            {1, 3, 5},
            {2, 4}
        };

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(startStr);
        visited.add(startStr);

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (curr.equals(target)) {
                    return steps;
                }

                int zeroIdx = curr.indexOf('0');
                char[] currArr = curr.toCharArray();

                for (int nextIdx : neighbors[zeroIdx]) {
                    char[] nextArr = currArr.clone();
                    nextArr[zeroIdx] = nextArr[nextIdx];
                    nextArr[nextIdx] = '0';
                    String nextStr = new String(nextArr);

                    if (!visited.contains(nextStr)) {
                        visited.add(nextStr);
                        queue.offer(nextStr);
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}