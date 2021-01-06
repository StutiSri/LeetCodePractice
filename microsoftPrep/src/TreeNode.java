class TreeNode {
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