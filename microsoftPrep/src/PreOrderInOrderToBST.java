public class PreOrderInOrderToBST {
    private static int indexInInPreOrder = 0;

    public TreeNode createBST(int[] preorder, int[] inorder, int n) {
        if (preorder.length == 0) {
            return null;
        }
        return bst(preorder, inorder, 0, n - 1);
    }

    private TreeNode bst(int[] preorder, int[] inOrder, int startIndexInInOrder, int endIndexInInorder) {

        if (startIndexInInOrder > endIndexInInorder || indexInInPreOrder == preorder.length - 1) {
            return null;
        }

        int currValue = preorder[indexInInPreOrder++];
        TreeNode currRoot = new TreeNode(currValue);

        int indexInInOrder = getIndexInInOrder(inOrder, startIndexInInOrder, endIndexInInorder, currValue);
        TreeNode leftRoot = bst(preorder, inOrder, startIndexInInOrder, indexInInOrder - 1);
        TreeNode rightRoot = bst(preorder, inOrder, indexInInOrder + 1, endIndexInInorder);
        currRoot.left = leftRoot;
        currRoot.right = rightRoot;
        return currRoot;
    }

    private int getIndexInInOrder(int[] arr, int start, int end, int key) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        if (arr[mid] > key) {
            return getIndexInInOrder(arr, start, mid - 1, key);
        }
        return getIndexInInOrder(arr, mid + 1, end, key);
    }
}
