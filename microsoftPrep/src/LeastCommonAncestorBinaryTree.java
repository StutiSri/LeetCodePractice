class LeastCommonAncestorBinaryTree {

    TreeNode lca(TreeNode root, int n1, int n2) {
        TreeNode ancestor = findLCA(root, n1, n2);
        if (ancestor.isAncestor) {
            return ancestor;
        }
        return null;
    }

    private TreeNode findLCA(TreeNode root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        boolean rootHasValue = root.val == n1 || root.val == n2;
        TreeNode nodeInLeft = findLCA(root.left, n1, n2);
        TreeNode nodeInRight = findLCA(root.right, n1, n2);
        if (rootHasValue && (nodeInLeft != null || nodeInRight != null)) {
            root.isAncestor = true;
            return root;
        }
        if(rootHasValue){
            return root;
        }
        if (nodeInRight != null && nodeInLeft != null) {
            root.isAncestor = true;
            return root;
        }
        if (nodeInLeft != null) {
            return nodeInLeft;
        }
        return nodeInRight;
    }
}
