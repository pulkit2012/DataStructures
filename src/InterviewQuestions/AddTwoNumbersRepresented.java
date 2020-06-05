package InterviewQuestions;

import java.util.Scanner;

public class AddTwoNumbersRepresented {
    static class Node {
        int data;
        Node next;
    }

    static Node head1;
    static Node head2;
    static Node addTwoList(Node head1,Node head2){
        String s1 = "";
        String s2 = "";
        Node str1 = head1;
        while(str1 != null){
            s1 += str1.data;
            str1 = str1.next;
        }
        str1 = head2;
        while(str1 != null){
            s2 += str1.data;
            str1 = str1.next;
        }
        String ans = String.valueOf(Integer.parseInt(s1) + Integer.parseInt(s2));
        Node head3 = null;
        for (int i = 0; i < ans.length(); i++) {
            Node node = new Node();
            node.data = Integer.parseInt(String.valueOf(ans.charAt(i)));
            node.next = head3;
            head3 = node;
        }
        return head3;
    }


    static void push1(int new_data) {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = head1;
        head1 = new_node;
    }
    static void push2(int new_data) {
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
        push1(5);
        push1(4);
        push2(5);
        push2(4);
        push2(3);
        System.out.println("First List ");
        printList(head1);
        System.out.println("Second List ");
        printList(head2);
        System.out.println("Added list ");
        printList(addTwoList(head1,head2));
    }
}
class test{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        if(a != 0){
            System.out.println(1);
        }
        for (int i = 1; i < a; i++) {
            for (int i1 = 0; i1 <= i; i1++) {
                System.out.print((i1 == 0 || i1 == i) ? i : 0);
            }
            System.out.println();
        }
    }
}
