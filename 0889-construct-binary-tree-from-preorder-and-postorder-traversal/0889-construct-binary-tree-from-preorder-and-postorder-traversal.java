import java.util.*;

class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
    
    private TreeNode build(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd) return root;
        
        int nextVal = pre[preStart + 1];
        int mid = map.get(nextVal);
        int leftSize = mid - postStart + 1;
        
        root.left = build(pre, preStart + 1, preStart + leftSize, post, postStart, mid, map);
        root.right = build(pre, preStart + leftSize + 1, preEnd, post, mid + 1, postEnd - 1, map);
        
        return root;
    }
}