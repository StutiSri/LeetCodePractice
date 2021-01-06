import java.util.HashMap;
import java.util.Map;

public class CloneLinkedListWithNextAndRandomPointer {
    class Node {
        int data;
        Node next, arb;

        Node(int d) {
            data = d;
            next = arb = null;

        }
    }

    Node copyList(Node head) {
        if (head == null) {
            return head;
        }
        Map<Node, Integer> origList = new HashMap<>();
        int i = 0;
        Node currt = head;
        while (currt != null) {
            origList.put(currt, i);
            currt = currt.next;
            i++;
        }

        Map<Integer, Node> clonedList = new HashMap<>();
        Node clonedHead;
        while (head != null) {
            int indexOfHead = origList.get(head);
            Node curr = clonedList.getOrDefault(indexOfHead, null);
            if (curr == null) {
                curr = new Node(head.data);
                clonedList.put(indexOfHead, curr);
            }
            if (head.next != null) {
                int indexOfNext = origList.get(head.next);
                Node next = clonedList.getOrDefault(indexOfNext, null);
                if (next == null) {
                    next = new Node(head.next.data);
                    clonedList.put(indexOfNext, next);
                }
                curr.next = next;
            }
            if (head.arb != null) {
                int indexOfNext = origList.get(head.arb);
                Node next = clonedList.getOrDefault(indexOfNext, null);
                if (next == null) {
                    next = new Node(head.arb.data);
                    clonedList.put(indexOfNext, next);
                }
                curr.arb = next;
            }
            head = head.next;
        }
        return clonedList.get(0);
    }
}
