class LeavesToLinkedList {
    private TreeNode currentLeafNode = null;

    void connect(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            root.isLeaf = true;
            if (currentLeafNode != null) {
                currentLeafNode.right = root;
            }
            currentLeafNode = root;
        } else {
            connect(root.left);
            connect(root.right);
        }
    }
}
