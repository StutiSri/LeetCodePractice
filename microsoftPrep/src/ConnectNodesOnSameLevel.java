
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class ConnectNodesOnSameLevel {
    Map<Integer, TreeNode> connect(TreeNode root) {
        Map<Integer, TreeNode> firstNodesHere = new HashMap<>();
        if (root == null) {
            firstNodesHere.put(0, null);
            return firstNodesHere;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, TreeNode> connected = new HashMap<>();
        root.height = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            int currentHeight = curr.height;
            TreeNode lastNodeAtThisHeight = connected.getOrDefault(currentHeight, null);
            if (lastNodeAtThisHeight == null) {
                firstNodesHere.put(currentHeight, curr);
            } else {
                lastNodeAtThisHeight.next = curr;
            }
            connected.put(currentHeight, curr);
            System.out.println(curr.val);
            TreeNode left = curr.left;
            if (left != null) {
                left.height = currentHeight + 1;
                queue.add(left);
            }
            TreeNode right = curr.right;
            if (right != null) {
                right.height = currentHeight + 1;
                queue.add(right);
            }
        }
        return firstNodesHere;
    }
}
