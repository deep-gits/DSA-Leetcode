class Solution {
    private int postIdx;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length - 1;
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }

        int rootVal = postorder[postIdx--];
        TreeNode root = new TreeNode(rootVal);
        int index = inorderMap.get(rootVal);

        root.right = helper(postorder, index + 1, inRight);
        root.left = helper(postorder, inLeft, index - 1);

        return root;
    }
}