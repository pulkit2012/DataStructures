package InterviewQuestions;


public class IntersectionPoint {
    static class Node {
        int data;
        Node next;
    }

    static Node head1;
    static Node head2;

    static int getSize(Node node) {
        Node temp = node;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    static int ValueGetter() {
        int sizeList1 = getSize(head1);
        int sizeList2 = getSize(head2);
        if (sizeList1 > sizeList2) {
            return intersectionPointgetter(sizeList1 - sizeList2, head1, head2);
        } else {
            return intersectionPointgetter(sizeList2 - sizeList1, head2, head1);
        }
    }

    static int intersectionPointgetter(int d, Node largeHead, Node smallHead) {
        Node current1 = largeHead;
        Node current2 = smallHead;
        for (int i = 0; i < d; i++) {
            if (current1 == null) {
                return -1;
            }
            current1 = current1.next;
        }
        while (current1 != null && current2 != null) {
            if (current1.data == current2.data) {
                return current1.data;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return -1;
    }


    static void pushHead1(int new_data) {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = head1;
        head1 = new_node;
    }

    static void pushHead2(int new_data) {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = head2;
        head2 = new_node;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        pushHead1(30);
        pushHead1(15);
        pushHead1(9);
        pushHead1(6);
        pushHead1(3);
        pushHead2(30);
        pushHead2(15);
        pushHead2(10);
        System.out.print("List 1 : ");
        printList(head1);
        System.out.print("List 2 : ");
        printList(head2);
        System.out.println("Intersection point is at node having value " + ValueGetter());
    }
}
