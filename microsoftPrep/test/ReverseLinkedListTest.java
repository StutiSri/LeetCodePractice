import org.junit.jupiter.api.Test;

class ReverseLinkedListTest {
    @Test
    void shouldReverseLinkedList() {
        ReverseLinkedList.Node nodeFirst = new ReverseLinkedList.Node(3);
        ReverseLinkedList.Node nodeSecond = new ReverseLinkedList.Node(13);
        ReverseLinkedList.Node nodeThird = new ReverseLinkedList.Node(23);
        ReverseLinkedList.Node nodeFourth = new ReverseLinkedList.Node(63);
        ReverseLinkedList.Node nodeFifth = new ReverseLinkedList.Node(37);
        ReverseLinkedList.Node nodeSixth = new ReverseLinkedList.Node(33);
        ReverseLinkedList.Node nodeSeventh = new ReverseLinkedList.Node(31);
        ReverseLinkedList.Node nodeEight = new ReverseLinkedList.Node(300);

        nodeFirst.next = nodeSecond;
        nodeSecond.next = nodeThird;
        nodeThird.next = nodeFourth;
        nodeFourth.next = nodeFifth;
        nodeFifth.next = nodeSixth;
        nodeSixth.next = nodeSeventh;
        nodeSeventh.next = nodeEight;

        ReverseLinkedList.Node newNode = new ReverseLinkedList().reverse(nodeFirst);

        int[] expected = new int[]{300, 31, 33, 37, 63, 23, 13, 3};
        for (int val : expected) {
            assert newNode.val == val;
            newNode = newNode.next;
        }

    }

    @Test
    void shouldReverseLinkedListNull() {
        ReverseLinkedList.Node newNode = new ReverseLinkedList().reverse(null);
        assert newNode == null;
    }

    @Test
    void shouldReverseLinkedListSingle() {
        ReverseLinkedList.Node head = new ReverseLinkedList.Node(3);
        ReverseLinkedList.Node newNode = new ReverseLinkedList().reverse(head);
        assert newNode == head;
        assert newNode.next == null;
    }
}