import java.util.Arrays;

class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        // 1. Initialize the matrix
        int[][] matrix = new int[m][n];
        
        // Fill the matrix with -1 initially
        for (int[] row : matrix) {
            Arrays.fill(row, -1);
        }
        
        // 2. Define the four boundaries
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        
        ListNode curr = head;
        
        // Continue spiraling as long as we have nodes in the linked list
        while (curr != null) {
            // Step 1: Move Left to Right (Top row)
            for (int j = left; j <= right; j++) {
                if (curr == null) break;
                matrix[top][j] = curr.val;
                curr = curr.next;
            }
            top++; // Shrink top boundary
            
            // Step 2: Move Top to Bottom (Right column)
            for (int i = top; i <= bottom; i++) {
                if (curr == null) break;
                matrix[i][right] = curr.val;
                curr = curr.next;
            }
            right--; // Shrink right boundary
            
            // Step 3: Move Right to Left (Bottom row)
            for (int j = right; j >= left; j--) {
                if (curr == null) break;
                matrix[bottom][j] = curr.val;
                curr = curr.next;
            }
            bottom--; // Shrink bottom boundary
            
            // Step 4: Move Bottom to Top (Left column)
            for (int i = bottom; i >= top; i--) {
                if (curr == null) break;
                matrix[i][left] = curr.val;
                curr = curr.next;
            }
            left++; // Shrink left boundary
        }
        
        return matrix;
    }
}