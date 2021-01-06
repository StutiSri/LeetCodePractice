import org.junit.jupiter.api.Test;

import java.util.Map;

class ConnectNodesOnSameLevelTest {
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

        Map<Integer, TreeNode> connect = new ConnectNodesOnSameLevel().connect(root);
        for (Map.Entry<Integer, TreeNode> integerTreeNodeEntry : connect.entrySet()) {
            TreeNode value = integerTreeNodeEntry.getValue();
            while (value != null){
                System.out.print(value.val + " ");
                value = value.next;
            }
            System.out.println();
        }
    }

    @Test
    void test2() {
        TreeNode root = new TreeNode(10);

        Map<Integer, TreeNode> connect = new ConnectNodesOnSameLevel().connect(root);
        for (Map.Entry<Integer, TreeNode> integerTreeNodeEntry : connect.entrySet()) {
            TreeNode value = integerTreeNodeEntry.getValue();
            while (value != null){
                System.out.print(value.val + " ");
                value = value.next;
            }
            System.out.println();
        }
    }

    @Test
    void test3() {
        TreeNode root = null;

        Map<Integer, TreeNode> connect = new ConnectNodesOnSameLevel().connect(root);
        for (Map.Entry<Integer, TreeNode> integerTreeNodeEntry : connect.entrySet()) {
            TreeNode value = integerTreeNodeEntry.getValue();
            while (value != null){
                System.out.print(value.val + " ");
                value = value.next;
            }
            System.out.println();
        }
    }
}