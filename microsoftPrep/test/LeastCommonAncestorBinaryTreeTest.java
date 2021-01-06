import org.junit.jupiter.api.Test;

class LeastCommonAncestorBinaryTreeTest {
    @Test
    void test1() {
        TreeNode root = root();

        TreeNode lca = new LeastCommonAncestorBinaryTree().lca(root, 7, 25);
        assert lca.val == 10;
    }

    @Test
    void test2() {
        TreeNode root = root();

        TreeNode lca = new LeastCommonAncestorBinaryTree().lca(root, 7, 8);
        assert lca.val == 8;
    }

    @Test
    void test3() {
        TreeNode root = root();

        TreeNode lca = new LeastCommonAncestorBinaryTree().lca(root, 7, 9);
        assert lca.val == 8;
    }

    @Test
    void test4() {
        TreeNode root = root();

        TreeNode lca = new LeastCommonAncestorBinaryTree().lca(root, 9, 12);
        assert lca.val == 10;
    }

    @Test
    void test5() {
        TreeNode root = root();

        TreeNode lca = new LeastCommonAncestorBinaryTree().lca(root, 9, 1);
        assert lca == null;
    }

    private TreeNode root() {
        TreeNode root = new TreeNode(10);
        TreeNode l = new TreeNode(8);
        TreeNode r = new TreeNode(20);
        root.left = l;
        root.right = r;

        TreeNode ll = new TreeNode(7);
        TreeNode lr = new TreeNode(9);

        l.left = ll;
        l.right = lr;

        TreeNode lrl = new TreeNode(24);
        TreeNode lrr = new TreeNode(30);

        lr.left = lrl;
        lr.right = lrr;

        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(25);

        r.left = rl;
        r.right = rr;

        TreeNode rll = new TreeNode(12);
        TreeNode rlr = new TreeNode(26);

        rl.left = rll;
        rl.right = rlr;
        return root;
    }
}