import org.junit.jupiter.api.Test;

class LeavesToLinkedListTest {
    @Test
    void test1() {
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

        new LeavesToLinkedList().connect(root);
        traverse(root);
    }

    @Test
    void test2() {
        TreeNode root = new TreeNode(10);
        new LeavesToLinkedList().connect(root);
        traverse(root);
    }

    @Test
    void test3() {
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(9);
        root.left = left;
        root.right = right;
        new LeavesToLinkedList().connect(root);
        traverse(root);
    }

    @Test
    void test4() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(1);
        new LeavesToLinkedList().connect(root);
        traverse(root);
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        assert (root.left == null && root.right == null) || root.next == null;
        if (root.isLeaf && !root.isVisited) {
            TreeNode curr = root;
            while (curr != null) {
                System.out.print(curr.val + " ");
                curr.isVisited = true;
                curr = curr.right;
            }
            System.out.println();
        }
        traverse(root.left);
        traverse(root.right);
    }
}