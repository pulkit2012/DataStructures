package InterviewQuestions;

import java.util.Stack;

public class linkedListReverseInGroup {
    static class Node {
        int data;
        Node next;
    }

    static Node head = null;

    static Node Reverse(Node head, int k) {
        Stack<Node> mystack = new Stack<Node>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            int count = 0;
            while (current != null && count < k) {
                mystack.push(current);
                current = current.next;
                count++;
            }
            while (mystack.size() > 0) {
                if (prev == null) {
                    prev = mystack.peek();
                    head = prev;
                    mystack.pop();
                } else {
                    prev.next = mystack.peek();
                    prev = prev.next;
                    mystack.pop();
                }
            }
        }
        prev.next = null;

        return head;
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
        head = Reverse(head, 3);
        System.out.println();
        System.out.println("Reversed Linked list ");
        printList(head);
    }
}