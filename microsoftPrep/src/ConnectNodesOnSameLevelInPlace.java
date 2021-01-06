import java.util.LinkedList;
import java.util.Queue;

class ConnectNodesOnSameLevelInPlace {
    TreeNode connect(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        root.height = 1;
        queue.add(root);
        TreeNode currentNode = root;
        while (!queue.isEmpty()) {
            TreeNode nextNode = queue.remove();
            int currentHeight = nextNode.height;
            if (currentHeight == level && nextNode != root) {
                currentNode.right = nextNode;
            }
            if (currentHeight != level) {
                level = currentHeight;
                currentNode.right = null;
            }
            currentNode = nextNode;
            TreeNode left = nextNode.left;
            if (left != null) {
                left.height = currentHeight + 1;
                queue.add(left);
            }
            TreeNode right = nextNode.right;
            if (right != null) {
                right.height = currentHeight + 1;
                queue.add(right);
            }
        }
        return root;
    }
}
