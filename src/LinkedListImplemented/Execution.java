package LinkedListImplemented;


public class Execution {
    public static void main(String[] args) {
        Definition<Integer> list = new Definition<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        //method to print a linked list
        list.print();
        //method to remove an element from linked list
        list.remove();
        //Method to find middle element
        list.middle();
        //method to reverse a linked list
        list.printReverse();
    }
}
