import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SummationViaLinkedListTest {
    @Test
    void test1() {
        Node head1 = new Node(9);
        Node nodeSecond = new Node(9);
        Node nodeThird = new Node(9);
//        Node nodeFourth = new Node(9);
//        Node nodeFifth = new Node(9);
//        Node nodeSixth = new Node(9);
//        Node nodeSeventh = new Node(9);
//        Node nodeEight = new Node(9);

        head1.next = nodeSecond;
        nodeSecond.next = nodeThird;
//        nodeThird.next = nodeFourth;
//        nodeFourth.next = nodeFifth;
//        nodeFifth.next = nodeSixth;
//        nodeSixth.next = nodeSeventh;
//        nodeSeventh.next = nodeEight;
        
        Node head2 = new Node(9);
        Node node2Second = new Node(9);
        Node node2Third = new Node(9);
        Node node2Fourth = new Node(9);
        Node node2Fifth = new Node(9);
//        Node node2Sixth = new Node(9);

        head2.next = node2Second;
        node2Second.next = node2Third;
        node2Third.next = node2Fourth;
        node2Fourth.next = node2Fifth;
//        node2Fifth.next = node2Sixth;

        Node sum = new SummationViaLinkedList().sum(head1, head2);
        while (sum != null){
            System.out.println(sum.val);
            sum = sum.next;
        }
    }
}