public class MaxPathSumLeafToLeaf {
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

        Node rrrll = new Node(-19);
        Node rrrlr = new Node(-29);

        rrrl.left = rrrll;
        rrrl.right = rrrlr;

        int x = maxPathSum(root);
        System.out.println(result);
    }

    private static int maxPathSum(Node root) {
        if(root == null){
            return 0;
        }
        int l = maxPathSum(root.left);
        int r = maxPathSum(root.right);

        int temp = Math.max(l, r) + root.val;
        int ans = Math.max(temp, l + r + root.val);
        result = Math.max(temp, ans);
        return temp;
    }
}
