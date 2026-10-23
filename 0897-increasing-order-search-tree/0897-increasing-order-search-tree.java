class Solution {
    private TreeNode resNode;
    private TreeNode currNode;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        currNode = dummy;
        inorder(root);
        return dummy.right;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        node.left = null;
        currNode.right = node;
        currNode = node;
        inorder(node.right);
    }
}