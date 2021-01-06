import org.junit.jupiter.api.Test;

class ReverseLinkedListTest {
    @Test
    void shouldReverseLinkedList() {
        Node nodeFirst = new Node(3);
        Node nodeSecond = new Node(13);
        Node nodeThird = new Node(23);
        Node nodeFourth = new Node(63);
        Node nodeFifth = new Node(37);
        Node nodeSixth = new Node(33);
        Node nodeSeventh = new Node(31);
        Node nodeEight = new Node(300);

        nodeFirst.next = nodeSecond;
        nodeSecond.next = nodeThird;
        nodeThird.next = nodeFourth;
        nodeFourth.next = nodeFifth;
        nodeFifth.next = nodeSixth;
        nodeSixth.next = nodeSeventh;
        nodeSeventh.next = nodeEight;

        Node newNode = new ReverseLinkedList().reverse(nodeFirst);

        int[] expected = new int[]{300, 31, 33, 37, 63, 23, 13, 3};
        for (int val : expected) {
            assert newNode.val == val;
            newNode = newNode.next;
        }

    }

    @Test
    void shouldReverseLinkedListNull() {
        Node newNode = new ReverseLinkedList().reverse(null);
        assert newNode == null;
    }

    @Test
    void shouldReverseLinkedListSingle() {
        Node head = new Node(3);
        Node newNode = new ReverseLinkedList().reverse(head);
        assert newNode == head;
        assert newNode.next == null;
    }
}