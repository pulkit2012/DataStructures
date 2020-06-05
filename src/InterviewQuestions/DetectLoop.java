package InterviewQuestions;


import java.util.Scanner;

public class DetectLoop {
    static class Node {
        int data;
        Node next;
    }

    static Node head;

    /**
     * This is main method To detect loop in the linked list Using
     * Floyd's Detection Algorithm
     *
     * @param head
     * @return
     */
    static boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
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

    }
}

