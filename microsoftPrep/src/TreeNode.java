class TreeNode {
    public boolean isLeaf;
    public boolean isAncestor;
    TreeNode left;
    TreeNode right;
    int height;
    TreeNode next;
    boolean isVisited = false;
    int val;

    TreeNode(int val) {
        this.val = val;
    }
}