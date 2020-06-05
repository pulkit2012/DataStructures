package InterviewQuestions;

import java.util.Stack;

public class NthNodeFromEnd {
    static class Node {
        int data;
        Node next;
    }

    static Node head = null;
    static int getSize(Node head){
        int size = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        return size;
    }
    static int getNthFromLast(Node head,int pos){
        if(head == null){
            return -1;
        }
        int index = getSize(head) - pos;
        Node temp1 = head;
        while (index >= 0){
            temp1 = temp1.next;
            index--;
        }
        return temp1.data;
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


