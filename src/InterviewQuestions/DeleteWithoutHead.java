package InterviewQuestions;

public class DeleteWithoutHead {
    static class Node {
        int data;
        Node next;
    }

    static Node head = null;
    static void deleteNode(Node node){
        if(node == null){
            return;
        }
        if(node.next == null){
            System.out.println("This is last node");
            return;
        }
        node.data = node.next.data;
        node.next = node.next.next;
    }
    static void push(int new_data) {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = head;
        head = new_node;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        push(9);
        push(8);
        push(7);
        push(6);
        push(5);
        push(4);
        push(3);
        push(2);
        push(1);
        System.out.println("Given linked list ");
        printList(head);
        Node del = head.next;
        deleteNode(del);
        printList(head);

    }
}



