import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class SwappedBSTToOrigTest {

    private ArrayList<Integer> allVals;

    @Test
    void test1() {
        TreeNode root = new TreeNode(10);
        TreeNode l = new TreeNode(5);
        TreeNode r = new TreeNode(8);
        root.left = l;
        root.right = r;

        TreeNode ll = new TreeNode(2);
        TreeNode lr = new TreeNode(20);

        l.left = ll;
        l.right = lr;

        TreeNode correctRoot = new SwappedBSTToOrig().correctBST(root);
        allVals = new ArrayList<>();
        getList(correctRoot);
        assert allVals.get(0) == 2;
        assert allVals.get(1) == 5;
        assert allVals.get(2) == 8;
        assert allVals.get(3) == 10;
        assert allVals.get(4) == 20;
    }

    @Test
    void test2() {
        TreeNode root = new TreeNode(93);
        TreeNode l = new TreeNode(61);
        TreeNode r = new TreeNode(87);
        root.left = l;
        root.right = r;

        l.left = new TreeNode(9);

        TreeNode correctRoot = new SwappedBSTToOrig().correctBST(root);
        allVals = new ArrayList<>();
        getList(correctRoot);
        assert allVals.get(0) == 9;
        assert allVals.get(1) == 61;
        assert allVals.get(2) == 87;
        assert allVals.get(3) == 93;
    }

    private void getList(TreeNode root) {
        if (root == null) {
            return;
        }
        getList(root.left);
        allVals.add(root.val);
        getList(root.right);
    }

}