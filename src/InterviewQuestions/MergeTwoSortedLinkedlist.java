package InterviewQuestions;

public class MergeTwoSortedLinkedlist {
    static class Node {
        int data;
        Node next;
    }

    static Node head1;
    static Node head2;
    static Node merger(Node head1,Node head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        Node head3 = null;
        if(head1.data < head2.data){
            head3 = head1;
            head1 = head1.next;
        }
        else {
            head3 = head2;
            head2 = head2.next;
        }
        Node node = head3;
        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                node.next = head1;
                head1 = head1.next;
            }
            else {
                node.next = head2;
                head2 = head2.next;
            }
            node = node.next;
        }
        if(head1 == null){
            node.next = head2;
        }else {
            node.next = head1;
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
       push1(15);
       push1(10);
       push1(5);
       push2(20);
       push2(3);
       push2(2);
       System.out.println("Given linked list ");
       printList(head1);
       printList(head2);
       printList(merger(head1,head2));
    }
}
