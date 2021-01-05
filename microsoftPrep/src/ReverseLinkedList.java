class ReverseLinkedList {
    Node reverse(Node head) {
        if(head == null){
            return head;
        }
        Node prev = null;
        Node nextHead;
        while (head.next != null){
            nextHead = head.next;
            head.next = prev;
            prev = head;
            head = nextHead;
        }
        head.next = prev;
        return head;
    }

    static class Node {
        Node next;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

}
