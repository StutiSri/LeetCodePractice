public class SummationViaLinkedList {
    private static int carry = 0;

    public Node sum(Node head1, Node head2) {
        int n1 = 0;
        int n2 = 0;
        Node curr1 = head1;
        Node curr2 = head2;
        Node leftRem = null;
        while (curr1 != null) {
            n1++;
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            n2++;
            curr2 = curr2.next;
        }
        if (n1 > n2) {
            leftRem = head1;
            head1 = startHeadAtDiff(n1 - n2, leftRem);
        } else if (n1 < n2) {
            leftRem = head2;
            head2 = startHeadAtDiff(n2 - n1, leftRem);
        }
        Node sum;
        Node partialSum = sumRecur(head1, head2);
        if (leftRem != null) {
            sum = addLeftRem(leftRem);
            Node curr = sum;
            while (curr.next != null){
                curr = curr.next;
            }
            curr.next = partialSum;
        } else {
            sum = partialSum;
        }
        if (carry > 0) {
            Node finalCarryNode = new Node(carry);
            finalCarryNode.next = sum;
            sum = finalCarryNode;
        }
        return sum;
    }

    private Node addLeftRem(Node node) {
        if (node.next == null) {
            int sum = sumAndCarry(node.val, 0);
            return new Node(sum%10);
        }
        Node partSum = addLeftRem(node.next);
        int sum = sumAndCarry(node.val, 0);
        Node test = new Node(sum % 10);
        test.next = partSum;
        return test;
    }

    private int sumAndCarry(int val1, int val2) {
        int sum = val1 + val2 + carry;
        if(sum >= 10){
            carry = sum/10;
        }else {
            carry = 0;
        }
        return sum;
    }

    private Node startHeadAtDiff(int n, Node leftRem) {
        Node curr = leftRem;
        for (int i = 0; i < n - 1; i++) {
            curr = curr.next;
        }
        Node newHead = curr.next;
        curr.next = null;
        return newHead;
    }

    private Node sumRecur(Node head1, Node head2) {
        if (head1.next == null) {
            int sum = sumAndCarry(head1.val, head2.val);
            return new Node(sum % 10);
        }

        Node sumSoFar = sumRecur(head1.next, head2.next);
        int sumVal = sumAndCarry(head1.val, head2.val);
        Node sumForThis = new Node(sumVal % 10);
        sumForThis.next = sumSoFar;
        return sumForThis;
    }
}
