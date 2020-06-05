package InterviewQuestions;

import java.util.HashSet;
import java.util.Stack;

public class detectAndRemoveLoop {

    static class Node {
        int data;
        Node next;
    }
    static Node head = null;
    static boolean removeLoop(Node head){
        HashSet<Node> s = new HashSet<>();
        Node temp = null;
        while(head != null){
            if(s.contains(head)){
                temp.next = null;
                return true;
            }
            else {
                s.add(head);
                temp = head;
                head = head.next;
            }
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
        detectAndRemoveLoop list = new detectAndRemoveLoop();
        push(9);
        push(8);
        push(7);
        push(6);
        list.head.next.next.next.next = list.head;
        if(removeLoop(head)){
            System.out.println("Removed loop");
            printList(head);
        }
        else {
            System.out.println("No loop");
        }
    }
}
