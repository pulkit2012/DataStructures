package InterviewQuestions;

public class LinkedListOf0s1s2sSortit {
    static class Node {
        int data;
        Node next;
    }

    static Node head = null;
    public static Node sorter(Node head){
        Node temp = head;
        int[] count = {0,0,0};
        while(temp != null){
            count[temp.data]++;
            temp = temp.next;
        }
        temp = head;
        int i = 0;
        while(temp != null){
            if(count[i] == 0){
                i++;
            }
            else {
                temp.data = i;
                --count[i];
                temp = temp.next;
            }
        }
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
        push(2);
        push(2);
        push(0);
        push(2);
        push(1);
        push(2);
        push(2);
        push(1);
        //push(1);
        System.out.println("Given linked list ");
        printList(head);
        printList(sorter(head));


    }
}



