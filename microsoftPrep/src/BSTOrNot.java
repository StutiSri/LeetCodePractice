public class BSTOrNot {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode l = new TreeNode(8);
        TreeNode r = new TreeNode(20);
        root.left = l;
        root.right = r;

        TreeNode ll = new TreeNode(7);
        TreeNode lr = new TreeNode(9);

        l.left = ll;
        l.right = lr;

//        TreeNode lrl = new TreeNode(24);
//        TreeNode lrr = new TreeNode(30);
//
//        lr.left = lrl;
//        lr.right = lrr;

        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(25);

        r.left = rl;
        r.right = rr;

        TreeNode rll = new TreeNode(12);
        TreeNode rlr = new TreeNode(26);

        rl.left = rll;
        rl.right = rlr;

        System.out.println(new BSTOrNot().isBST(root, null, null));
    }

    private boolean isBST(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null){
            return true;
        }
        if(min != null && root.val <= min.val){
            return false;
        }
        if(max != null && root.val >= max.val){
            return false;
        }
        return isBST(root.left, min, root) && isBST(root.right, root, max);
    }
}
