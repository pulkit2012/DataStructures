package InterviewQuestions;

import java.util.Stack;

public class PairwiseSwap {
    static class Node {
        int data;
        Node next;
    }

    static Node head = null;

    static Node pairWiseSwap(Node head) {
        Stack<Node> s = new Stack<>();
        if (head == null) {
            return null;
        }
        Node prev = null;
        Node temp = head;
        while (temp != null) {
            int k = 2;
            while (temp != null && k > 0) {
                s.push(temp);
                temp = temp.next;
                k--;
            }
            while (s.size() > 0) {
                if (prev == null) {
                    prev = s.peek();
                    head = prev;
                    s.pop();
                } else {
                    prev.next = s.peek();
                    prev = prev.next;
                    s.pop();
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
        System.out.println();
    }

    public static void main(String[] args) {
        push(8);
        push(7);
        push(6);
        push(5);
        push(4);
        push(2);
        push(2);
        push(1);
        //push(1);
        System.out.println("Given linked list ");
        printList(head);
        System.out.println("Swapped list");
        printList(pairWiseSwap(head));

    }
}


