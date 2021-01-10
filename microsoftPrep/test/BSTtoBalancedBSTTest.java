import org.junit.jupiter.api.Test;

class BSTtoBalancedBSTTest {
    @Test
    void test1() {
        TreeNode root = root();

        TreeNode balancedRoot = new BSTtoBalancedBST().balance(root);

        assert balancedRoot.val == 15;

        TreeNode l = balancedRoot.left;
        assert l.val == 9;

        TreeNode ll = l.left;
        assert ll.val == 7;

        TreeNode lll = ll.left;
        assert lll == null;

        TreeNode llr = ll.right;
        assert llr.val == 8;

        TreeNode lr = l.right;
        assert lr.val == 10;

        TreeNode lrl = lr.left;
        assert lrl == null;

        TreeNode lrr = lr.right;
        assert lrr.val == 12;

        TreeNode r = balancedRoot.right;
        assert r.val == 25;

        TreeNode rl = r.left;
        assert rl.val == 20;

        TreeNode rll = rl.left;
        assert rll == null;

        TreeNode rlr = rl.right;
        assert rlr.val == 24;

        TreeNode rr = r.right;
        assert rr.val == 26;

        TreeNode rrl = rr.left;
        assert rrl == null;

        TreeNode rrr = rr.right;
        assert rrr.val == 30;
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

        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(25);

        r.left = rl;
        r.right = rr;

        TreeNode rll = new TreeNode(12);
        rl.left = rll;

        TreeNode rrl = new TreeNode(24);
        TreeNode rrr = new TreeNode(26);

        rr.left = rrl;
        rr.right = rrr;

        TreeNode rrrr = new TreeNode(30);

        rrr.right = rrrr;
        return root;
    }
}