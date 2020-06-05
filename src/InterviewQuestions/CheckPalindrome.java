package InterviewQuestions;

import java.util.Stack;

public class CheckPalindrome {
    static class Node {
        int data;
        Node next;
    }

    static Node head = null;
    static boolean isPalindrome(Node head){
        Node temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null){
            stack.add(temp.data);
            temp = temp.next;
        }
        temp = head;
        boolean isPalindrome = false;
        while (stack.size() > 0){
            int data = stack.peek();
            if(data == temp.data){
                isPalindrome = true;
                temp = temp.next;
                stack.pop();
            }
            else {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
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
        push(1);
        push(2);
        push(3);
        push(4);
        push(3);
        push(2);
        push(1);
       // push(5);
        System.out.println("Given linked list ");
        printList(head);
        System.out.println(isPalindrome(head) ? "Yes it is palindrome": "No it is not a palindrome");

    }
}



