import java.util.ArrayList;
import java.util.List;

class BSTtoBalancedBST {

    List<Integer> sortedArr = new ArrayList<>();

    TreeNode balance(TreeNode root) {
        inorder(root);
        return balanceIt(0, sortedArr.size() - 1);
    }

    private TreeNode balanceIt(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(sortedArr.get(mid));
        root.left = balanceIt(start, mid - 1);
        root.right = balanceIt(mid + 1, end);
        return root;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        sortedArr.add(root.val);
        inorder(root.right);
    }
}
