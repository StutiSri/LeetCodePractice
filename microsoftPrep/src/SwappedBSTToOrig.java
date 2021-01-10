import java.util.ArrayList;
import java.util.List;

public class SwappedBSTToOrig {

    private List<TreeNode> inorder = new ArrayList<>();

    public TreeNode correctBST(TreeNode root) {
        findFaulties(root);
        TreeNode firstTreeNode = firstFaulty();
        TreeNode lastFaulty = lastFaulty();
        if (firstTreeNode != null && lastFaulty != null) {
            int temp = firstTreeNode.val;
            firstTreeNode.val = lastFaulty.val;
            lastFaulty.val = temp;
        }

        return root;
    }

    private TreeNode lastFaulty() {
        int n = inorder.size();
        int indexCurr = n - 1;
        int indexPrev = n - 2;
        while (indexPrev >= 0) {
            TreeNode currentNode = inorder.get(indexCurr);
            TreeNode prevNode = inorder.get(indexPrev);
            if (prevNode.val > currentNode.val) {
                return currentNode;
            }
            indexCurr--;
            indexPrev--;
        }
        return inorder.get(0);
    }

    private TreeNode firstFaulty() {
        int indexCurr = 0;
        int indexNext = 1;
        while (indexNext < inorder.size()) {
            TreeNode currentNode = inorder.get(indexCurr);
            TreeNode nextNode = inorder.get(indexNext);
            if (currentNode.val > nextNode.val) {
                return currentNode;
            }
            indexCurr++;
            indexNext++;
        }
        return inorder.get(indexCurr);
    }

    private void findFaulties(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        findFaulties(left);
        inorder.add(root);
        findFaulties(right);

    }

}
