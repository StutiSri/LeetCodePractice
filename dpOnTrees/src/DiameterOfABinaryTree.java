public class DiameterOfABinaryTree {
    private static int result = Integer.MIN_VALUE;

    static class Node {
        Node left;
        Node right;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        Node l = new Node(10);
        Node r = new Node(1);
        root.left = l;
        root.right = r;

        Node ll = new Node(5);
        Node lr = new Node(3);

        l.left = ll;
        l.right = lr;

        Node lrl = new Node(24);
        Node lrr = new Node(30);

        lr.left = lrl;
        lr.right = lrr;

        Node rr = new Node(2);
        r.right = rr;

        Node rrr = new Node(12);
        rr.right = rrr;

        Node rrrl = new Node(9);
        Node rrrr = new Node(10);

        rrr.left = rrrl;
        rrr.right = rrrr;

        Node rrrll = new Node(19);
        Node rrrlr = new Node(29);

        rrrl.left = rrrll;
        rrrl.right = rrrlr;

        int x = longestPathLength(root);
        System.out.println(result);

    }

    private static int longestPathLength(Node root) {
        if (root == null) {
            return 0;
        }
        int l = longestPathLength(root.left);
        int r = longestPathLength(root.right);

        int pathIncludingRoot = 1 + l + r;

        int pathWithoutIncludingRoot = 1 + Math.max(l, r);
        int ans = Math.max(pathWithoutIncludingRoot, pathIncludingRoot);
        result = Math.max(ans, result);
        return pathWithoutIncludingRoot;
    }
}
