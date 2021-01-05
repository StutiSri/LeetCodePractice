public class BSTOrNot {
    static class Node {
        Node left;
        Node right;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        Node l = new Node(8);
        Node r = new Node(20);
        root.left = l;
        root.right = r;

        Node ll = new Node(7);
        Node lr = new Node(9);

        l.left = ll;
        l.right = lr;

//        Node lrl = new Node(24);
//        Node lrr = new Node(30);
//
//        lr.left = lrl;
//        lr.right = lrr;

        Node rl = new Node(15);
        Node rr = new Node(25);

        r.left = rl;
        r.right = rr;

        Node rll = new Node(12);
        Node rlr = new Node(26);

        rl.left = rll;
        rl.right = rlr;

        System.out.println(new BSTOrNot().isBST(root, null, null));
    }

    private boolean isBST(Node root, Node min, Node max) {
        if(root == null){
            return true;
        }
        if(min != null && root.val <= min.val){
            return false;
        }
        if(max != null && root.val >= max.val){
            return false;
        }
        return isBST(root.left, min, root) && isBST(root.right, root, max);
    }
}
