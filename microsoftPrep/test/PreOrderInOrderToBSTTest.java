import org.junit.jupiter.api.Test;

class PreOrderInOrderToBSTTest {
    @Test
    void test1() {
        int[] preorder = new int[]{10, 8, 7, 5, 9, 20, 15, 12, 16, 25, 30};
        int[] inorder = new int[]{5, 7, 8, 9, 10, 12, 15, 16, 20, 25, 30};

        TreeNode root = new PreOrderInOrderToBST().createBST(preorder, inorder, preorder.length);
        assert root.val == 10;

        TreeNode l = root.left;
        assert l.val == 8;

        TreeNode ll = l.left;
        assert ll.val == 7;

        TreeNode lll = ll.left;
        assert lll.val == 5;

        TreeNode llr = ll.right;
        assert llr == null;

        TreeNode lr = l.right;
        assert lr.val == 9;

        TreeNode r = root.right;
        assert r.val == 20;

        TreeNode rl = r.left;
        assert rl.val == 15;

        TreeNode rll = rl.left;
        assert rll.val == 12;

        TreeNode rlr = rl.right;
        assert rlr.val == 16;

        TreeNode rr = r.right;
        assert rr.val == 25;

        TreeNode rrl = rr.left;
        assert rrl == null;

        TreeNode rrr = rr.right;
        assert rrr.val == 30;


    }

    @Test
    void test2() {
        int[] preorder = new int[]{};
        int[] inorder = new int[]{};

        TreeNode root = new PreOrderInOrderToBST().createBST(preorder, inorder, preorder.length);
        assert root == null;
    }

    @Test
    void test3() {
        int[] preorder = new int[]{1};
        int[] inorder = new int[]{1};

        TreeNode root = new PreOrderInOrderToBST().createBST(preorder, inorder, preorder.length);
        assert root.val == 1;
        assert root.left == null;
        assert root.right == null;
    }

    @Test
    void test4() {
        int[] preorder = new int[]{10, 8, 7, 5};
        int[] inorder = new int[]{5, 7, 8, 10};

        TreeNode root = new PreOrderInOrderToBST().createBST(preorder, inorder, preorder.length);
        assert root.val == 10;
        TreeNode l = root.left;
        assert l.val == 8;

        assert root.right == null;

        TreeNode ll = l.left;
        assert ll.val == 7;

        assert l.right == null;

        TreeNode lll = ll.left;
        assert lll.val == 5;

        assert ll.right == null;
        assert lll.left == null;
        assert lll.right == null;
    }

    @Test
    void test5() {
        int[] preorder = new int[]{10, 1, 30, 40, 20};
        int[] inorder = new int[]{1, 10, 20, 30, 40};

        TreeNode root = new PreOrderInOrderToBST().createBST(preorder, inorder, preorder.length);
        assert root.val == 10;

        TreeNode l = root.left;
        assert l.val == 1;

        assert l.left == null;
        assert l.right == null;

        TreeNode r = root.right;
        assert r.val == 30;

        TreeNode rl = r.left;
        assert rl.val == 20;

        assert rl.left == null;
        assert rl.right == null;

        TreeNode rr = r.right;
        assert rr.val == 40;

        assert rr.left == null;
        assert rr.right == null;

    }
}